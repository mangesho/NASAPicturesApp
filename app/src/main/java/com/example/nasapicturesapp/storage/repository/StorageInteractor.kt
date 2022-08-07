package com.example.nasapicturesapp.storage.repository

import com.example.nasapicturesapp.model.PictureData
import com.example.nasapicturesapp.model.asPictureData

class StorageInteractor(private var storageRepo: StorageRepo) {

    suspend fun getImageList(): List<PictureData> {
        val pictureResponseList = storageRepo.getImageList()
        pictureResponseList.sortBy { it.timeStamp }
        return pictureResponseList.asPictureData()
    }
}