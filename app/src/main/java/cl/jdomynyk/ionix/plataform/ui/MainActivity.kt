package cl.jdomynyk.ionix.plataform.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import cl.jdomynyk.ionix.R
import cl.jdomynyk.ionix.plataform.navigation.goToHome

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToMovie()
    }

    private fun moveToMovie() {
        val r = Runnable {
            goToHome()
        }
        Handler().postDelayed(r, 3000)
    }
}
