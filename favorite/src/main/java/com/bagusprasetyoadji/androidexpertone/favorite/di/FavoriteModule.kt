package com.bagusprasetyoadji.androidexpertone.favorite.di

import com.bagusprasetyoadji.androidexpertone.favorite.FavoriteViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

var favoriteModule = module(override = true) {
    viewModel { FavoriteViewModel(get()) }
}