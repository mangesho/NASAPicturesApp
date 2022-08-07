package com.example.nasapicturesapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageData(
    val copyright: String,
    val date: String,
    val description: String,
    val fullImageUrl: String,
    val title: String,
    val thumbnailUrl: String
) : Parcelable

fun List<ImageListResponse>.asImageData(): List<ImageData> {
    return map {
        ImageData(
            copyright = "@${it.copyright}",
            date = it.date,
            description = it.explanation,
            fullImageUrl = it.hdurl,
            title = it.title,
            thumbnailUrl = it.url
        )
    }
}