package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _addOrCancel = MutableLiveData<Boolean>()
    val addOrCancel: LiveData<Boolean>
        get() = _addOrCancel

    init {
        resetList()
    }

    private fun resetList() {
        _shoeList.value = mutableListOf(
            Shoe("air max 90", 42.0, "Nike", "nice", mutableListOf("image1", "image2"))
        )
    }

    fun addNewShoe(name: String, size: Double, company: String, description: String){
        val shoe = Shoe(name, size, company, description)
        _shoeList.value?.add(shoe)
        _addOrCancel.value = true
    }

    fun cancel(){
        _addOrCancel.value = true
    }

    fun addCompleted(){
        _addOrCancel.value = false
    }
}