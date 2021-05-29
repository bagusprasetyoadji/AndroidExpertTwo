package com.bagusprasetyoadji.androidexpertone.di

import com.bagusprasetyoadji.androidexpertone.core.domain.usecase.MovieInteractor
import com.bagusprasetyoadji.androidexpertone.core.domain.usecase.MovieUseCase
import com.bagusprasetyoadji.androidexpertone.detail.DetailMovieViewModel
import com.bagusprasetyoadji.androidexpertone.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}