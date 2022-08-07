package com.example.nasapicturesapp.storage.repository

import com.example.nasapicturesapp.storage.repository.impl.StorageImpl

class StorageRepo(private var storageImpl: StorageImpl) {

    suspend fun getImageList() = storageImpl.getDataFromJson()
}