package com.example.nasapicturesapp.storage.repository.impl

import com.example.nasapicturesapp.model.ImageListResponse

interface StorageInterface {

    suspend fun getDataFromJson() : ArrayList<ImageListResponse>

}