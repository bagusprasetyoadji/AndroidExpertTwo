package com.bagusprasetyoadji.androidexpertone.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val title : String,
    val description : String,
    val tanggal :String,
    val image : String,
    val isFavorite: Boolean
) : Parcelable