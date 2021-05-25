package com.bagusprasetyoadji.androidexpertone.detail

import androidx.lifecycle.ViewModel
import com.bagusprasetyoadji.androidexpertone.core.domain.model.Movie
import com.bagusprasetyoadji.androidexpertone.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoritemovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)
}

