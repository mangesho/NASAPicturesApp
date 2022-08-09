package com.example.nasapicturesapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {

    val isNetworkAvailable: MutableLiveData<Boolean> = MutableLiveData()
}