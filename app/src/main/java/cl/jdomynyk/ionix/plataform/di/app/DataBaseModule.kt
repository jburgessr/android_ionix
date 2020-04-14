package cl.jdomynyk.ionix.plataform.di.app

import android.app.Application
import android.view.MenuItem
import androidx.room.Room
import cl.jdomynyk.ionix.data.source.local.AppDatabase
import cl.jdomynyk.ionix.data.source.local.menu.MenuDao
import cl.jdomynyk.ionix.data.source.local.menu.MenuLocal
import cl.jdomynyk.ionix.data.source.local.menu.MenuLocalImpl
import cl.jdomynyk.ionix.data.source.remote.MenuService
import cl.jdomynyk.ionix.data.source.remote.SearchService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@Suppress("unused")
object DataBaseModule {
    @Provides
    @Singleton
    @JvmStatic
    fun provideDB(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application, AppDatabase::class.java, "ionix.db"
        ).build()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideNewsDao(appDatabase: AppDatabase): MenuDao {
        return appDatabase.getMenuDao()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideNewsLocalImpl(menuDao: MenuDao): MenuLocal {
        return MenuLocalImpl(menuDao)
    }
}