package cl.jdomynyk.ionix.presentation.formatter

import android.os.Build
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.inject.Inject


class Formatter @Inject constructor() {
    companion object {
        const val ALGORITHM = "DES"
        const val URL = "https://sandbox.ionix.cl/test-tecnico/search?rut="
    }

    fun formatFaIcon(icon: String): String = icon.replace("-", "_")

    fun completeUrlForSearch(rut: String): String = URL + rut

    fun getRutDes(rut: String): String {
        val keySpec = DESKeySpec("ionix123456".toByteArray(Charsets.UTF_8))
        val keyFactory = SecretKeyFactory.getInstance(ALGORITHM)
        val key = keyFactory.generateSecret(keySpec)

        val cleartext = rut.toByteArray(Charsets.UTF_8)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, key)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Base64.getEncoder().encodeToString(cipher.doFinal(cleartext))
        } else {
            android.util.Base64.encodeToString(
                cipher.doFinal(cleartext),
                android.util.Base64.DEFAULT
            )
        }
    }

}