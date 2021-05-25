package com.bagusprasetyoadji.androidexpertone.core.utils

import com.bagusprasetyoadji.androidexpertone.core.data.source.local.entity.MovieEntity
import com.bagusprasetyoadji.androidexpertone.core.data.source.remote.response.MovieResponse
import com.bagusprasetyoadji.androidexpertone.core.domain.model.Movie

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                tanggal = it.tanggal,
                image = it.image,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                description = it.description,
                tanggal = it.tanggal,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        description = input.description,
        tanggal = input.tanggal,
        image = input.image,
        isFavorite = input.isFavorite
    )
}