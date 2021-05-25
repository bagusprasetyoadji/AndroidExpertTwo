package com.bagusprasetyoadji.androidexpertone.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bagusprasetyoadji.androidexpertone.core.domain.usecase.MovieUseCase

class HomeViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovie().asLiveData()
}

