package com.example.nasapicturesapp.storage.repository

import com.example.nasapicturesapp.model.ImageData
import com.example.nasapicturesapp.model.asImageData
import javax.inject.Inject

class StorageInteractor @Inject constructor(private var storageRepo: StorageRepo) {

    suspend fun getImageList(): List<ImageData> {
        val pictureResponseList = storageRepo.getImageList()
        pictureResponseList.sortBy { it.timeStamp }
        return pictureResponseList.asImageData()
    }
}