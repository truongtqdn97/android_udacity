package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {
    private val _moveToList = MutableLiveData<Boolean>()
    val moveToList: LiveData<Boolean>
        get() = _moveToList

    fun moveNext(){
        _moveToList.value = true
    }
}