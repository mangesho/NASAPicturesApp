package com.example.nasapicturesapp.storage.repository.impl

import com.example.nasapicturesapp.model.PictureResponse

interface StorageInterface {

    suspend fun getDataFromJson() : ArrayList<PictureResponse>

}