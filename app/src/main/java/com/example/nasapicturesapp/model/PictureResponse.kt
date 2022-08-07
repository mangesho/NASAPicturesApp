package com.example.nasapicturesapp.model

import android.os.Parcelable
import com.example.nasapicturesapp.utils.Constants.DATE_FORMAT_YYYY_MM_DD
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter


@Parcelize
data class PictureResponse(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
): Parcelable{

    val timeStamp : Long
    get(){
        val formatter: DateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT_YYYY_MM_DD)
        val dt: DateTime = formatter.parseDateTime(date)
        return dt.millis
    }
}
