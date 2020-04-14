package cl.jdomynyk.ionix.plataform.navigation

import android.app.Activity
import cl.jdomynyk.ionix.plataform.ui.HomeActivity

fun Activity.goToHome() {
    HomeActivity.start(this)
    finish()
}
