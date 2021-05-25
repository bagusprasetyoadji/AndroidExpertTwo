package com.bagusprasetyoadji.androidexpertone.core.data.source.remote.network

import com.bagusprasetyoadji.androidexpertone.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular?api_key=afc1213e84fb637e510e20542b9ab3da&language=en-US&page=1")
    suspend fun getList(): ListMovieResponse
}
