package cl.jdomynyk.ionix.plataform.di.app

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
object NetworkModule {
    private const val URL_SEARCH = "https://sandbox.ionix.cl/test-tecnico/"
    private const val MENU_ITEM = "https://gitlab.com/jburgess/"

    @Provides
    @Singleton
    @JvmStatic
    fun provideSearchService(): SearchService {
        return Retrofit.Builder()
            .baseUrl(URL_SEARCH)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(SearchService::class.java)
    }

    @Provides
    @Singleton
    @JvmStatic
    fun provideMenuItemService(): MenuService {
        return Retrofit.Builder()
            .baseUrl(MENU_ITEM)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(MenuService::class.java)
    }

}