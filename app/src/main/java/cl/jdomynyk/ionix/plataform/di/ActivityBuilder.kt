package cl.jdomynyk.ionix.plataform.di

import cl.jdomynyk.ionix.plataform.di.home.HomeActivityModule
import cl.jdomynyk.ionix.plataform.ui.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    @PerActivity
    internal abstract fun bindListActivity(): HomeActivity

}