package com.example.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
    val messageForActivity: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrgmTp: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    val messageForFrgmBttn: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}