package com.ericson.prestameos.ui.prestameos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.PrestameoData
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.data.models.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class PrestameoViewModel @Inject constructor(private val data:PrestameoData) : ViewModel() {

    private val _message = MutableLiveData<Result<Boolean>>()
    val message: LiveData<Result<Boolean>> = _message
    fun add(prestameo: Prestameo){
       viewModelScope.launch {
          _message.value = data.add(prestameo)
       }
    }
}