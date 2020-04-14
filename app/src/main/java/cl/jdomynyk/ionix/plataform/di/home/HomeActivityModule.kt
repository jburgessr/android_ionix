package cl.jdomynyk.ionix.plataform.di.home

import cl.jdomynyk.ionix.domain.usecase.MenuUseCase
import cl.jdomynyk.ionix.domain.usecase.SearchUseCase
import cl.jdomynyk.ionix.presentation.HomePresenter
import cl.jdomynyk.ionix.presentation.formatter.Formatter
import dagger.Module
import dagger.Provides


@Module
class HomeActivityModule {

    @Provides
    internal fun providePresenter(
        formatter: Formatter,
        searchUseCase: SearchUseCase,
        menuUseCase: MenuUseCase
    ): HomePresenter {
        return HomePresenter(formatter, searchUseCase, menuUseCase)
    }

}