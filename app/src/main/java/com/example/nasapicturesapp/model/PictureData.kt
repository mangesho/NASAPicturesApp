package com.example.nasapicturesapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureData(
    val copyright: String,
    val date: String,
    val description: String,
    val fullImageUrl: String,
    val title: String,
    val thumbnailUrl: String
) : Parcelable

fun List<PictureResponse>.asPictureData(): List<PictureData> {
    return map {
        PictureData(
            copyright = "@${it.copyright}",
            date = it.date,
            description = it.explanation,
            fullImageUrl = it.hdurl,
            title = it.title,
            thumbnailUrl = it.url
        )
    }
}