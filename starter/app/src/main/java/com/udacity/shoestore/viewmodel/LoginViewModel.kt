package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _moveToWelcome = MutableLiveData<Boolean>()
    val moveToWelcome: LiveData<Boolean>
        get() = _moveToWelcome

    fun moveNext(){
        _moveToWelcome.value = true
    }
}