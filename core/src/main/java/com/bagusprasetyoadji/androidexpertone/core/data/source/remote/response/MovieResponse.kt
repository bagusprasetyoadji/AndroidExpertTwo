package com.bagusprasetyoadji.androidexpertone.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @field:SerializedName("id")
    val id: String,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("overview")
    val description: String,

    @field:SerializedName("release_date")
    val tanggal: String,

    @field:SerializedName("backdrop_path")
    val image: String
)

