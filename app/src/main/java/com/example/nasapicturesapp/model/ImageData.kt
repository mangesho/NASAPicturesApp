package com.example.nasapicturesapp.model

import android.os.Parcelable
import com.example.nasapicturesapp.utils.Constants
import kotlinx.parcelize.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Parcelize
data class ImageData(
    val copyright: String,
    val date: String,
    val description: String,
    val fullImageUrl: String,
    val title: String,
    val thumbnailUrl: String,
    val timeStamp: Long
) : Parcelable {

    val displayDate: String
        get() {
            val formatter = SimpleDateFormat(Constants.DATE_FORMAT_DD_MMM_YY)
            return formatter.format(Date(timeStamp))
        }
}

fun List<ImageListResponse>.asImageData(): List<ImageData> {
    return map {
        ImageData(
            copyright = if(it.copyright.isNullOrEmpty()) "" else "@${it.copyright}",
            date = if(it.date.isNullOrEmpty()) "" else it.date,
            description = if(it.explanation.isNullOrEmpty()) "" else it.explanation,
            fullImageUrl = if(it.hdurl.isNullOrEmpty()) "" else it.hdurl,
            title = if(it.title.isNullOrEmpty()) "" else it.title,
            thumbnailUrl = if(it.url.isNullOrEmpty()) "" else it.url,
            timeStamp = it.timeStamp
        )
    }
}