package com.bagusprasetyoadji.androidexpertone.core.domain.usecase

import com.bagusprasetyoadji.androidexpertone.core.data.Resource
import com.bagusprasetyoadji.androidexpertone.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
}