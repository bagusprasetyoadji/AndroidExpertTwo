package com.bagusprasetyoadji.androidexpertone.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bagusprasetyoadji.androidexpertone.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoritemovie = movieUseCase.getFavoriteMovie().asLiveData()
}

