package com.bagusprasetyoadji.androidexpertone.core.domain.repository

import com.bagusprasetyoadji.androidexpertone.core.data.Resource
import com.bagusprasetyoadji.androidexpertone.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)

}