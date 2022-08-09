package com.example.nasapicturesapp.storage.repository.impl

import android.content.Context
import com.example.nasapicturesapp.R
import com.example.nasapicturesapp.model.ImageListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class StorageImpl @Inject constructor(private var context: Context): StorageInterface {

    override suspend fun getDataFromJson(): ArrayList<ImageListResponse> {
        val res = context.resources.openRawResource(R.raw.data)
        val jsonString = res.bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, object : TypeToken<ArrayList<ImageListResponse>>(){}.type)
    }
}