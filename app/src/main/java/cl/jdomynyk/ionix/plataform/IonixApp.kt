package cl.jdomynyk.ionix.plataform

import cl.jdomynyk.ionix.plataform.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class IonixApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<IonixApp> {
        val component = DaggerAppComponent.builder().application(this).build()

        component.inject(this)

        return component
    }

}