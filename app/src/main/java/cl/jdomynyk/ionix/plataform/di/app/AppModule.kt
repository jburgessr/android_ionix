package cl.jdomynyk.ionix.plataform.di.app

import android.app.Application
import android.content.Context
import cl.jdomynyk.ionix.data.source.MenuRepositoryImpl
import cl.jdomynyk.ionix.data.source.SearchRepositoryImpl
import cl.jdomynyk.ionix.data.source.local.menu.MenuLocal
import cl.jdomynyk.ionix.data.source.remote.MenuService
import cl.jdomynyk.ionix.data.source.remote.SearchService
import cl.jdomynyk.ionix.domain.repository.MenuRepository
import cl.jdomynyk.ionix.domain.repository.SearchRepository
import cl.jdomynyk.ionix.domain.usecase.MenuUseCase
import cl.jdomynyk.ionix.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideSearchRepository(
        searchService: SearchService
    ): SearchRepository {
        return SearchRepositoryImpl(searchService)
    }

    @Provides
    @Singleton
    internal fun provideMenuRepository(
        menuService: MenuService,
        menuLocal: MenuLocal
    ): MenuRepository {
        return MenuRepositoryImpl(menuService, menuLocal)
    }

    @Provides
    @Singleton
    internal fun provideSearchUseCase(repository: SearchRepository): SearchUseCase {
        return SearchUseCase(repository)
    }


    @Provides
    @Singleton
    internal fun provideMenuUseCase(repository: MenuRepository): MenuUseCase {
        return MenuUseCase(repository)
    }
}
