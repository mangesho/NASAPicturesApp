package com.example.nasapicturesapp.storage.repository

import com.example.nasapicturesapp.storage.repository.impl.StorageImpl
import javax.inject.Inject

class StorageRepo @Inject constructor(private var storageImpl: StorageImpl) {

    suspend fun getImageList() = storageImpl.getDataFromJson()
}