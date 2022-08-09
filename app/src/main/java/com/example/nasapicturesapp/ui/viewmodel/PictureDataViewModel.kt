package com.example.nasapicturesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.nasapicturesapp.model.ImageData
import com.example.nasapicturesapp.storage.repository.StorageInteractor
import com.example.nasapicturesapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureDataViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var storageInteractor: StorageInteractor

    private val networkAvailable: MutableLiveData<Boolean> = isNetworkAvailable
    val eventNetworkAvailable: LiveData<Boolean>
        get() = networkAvailable

    private val showLoader: MutableLiveData<Boolean> = MutableLiveData()
    val eventShowLoader: LiveData<Boolean>
        get() = showLoader

    private val imageList: MutableLiveData<List<ImageData>> = MutableLiveData()
    val imageDataList: LiveData<List<ImageData>>
        get() = imageList

    fun getImageList(){
        showLoader.value = true
        viewModelScope.launch(Dispatchers.IO) {
            storageInteractor.getImageList().let {
                imageList.postValue(it)
                showLoader.postValue(false)
            }
        }
    }

}