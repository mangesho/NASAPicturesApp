package com.example.nasapicturesapp.storage.di

import android.app.Application
import android.content.Context
import com.example.nasapicturesapp.storage.repository.StorageInteractor
import com.example.nasapicturesapp.storage.repository.StorageRepo
import com.example.nasapicturesapp.storage.repository.impl.StorageImpl
import com.example.nasapicturesapp.storage.repository.impl.StorageInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideStorage(context: Context): StorageInterface = StorageImpl(context)


    @Provides
    @Singleton
    fun provideStorageRepo(storageImpl: StorageImpl) = StorageRepo(storageImpl)

    @Provides
    @Singleton
    fun provideStorageInteractor(storageRepo: StorageRepo) = StorageInteractor(storageRepo)
}