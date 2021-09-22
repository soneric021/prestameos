package com.ericson.prestameos.ui.prestameos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.PrestameoData
import com.ericson.prestameos.data.models.Prestameo
import kotlinx.coroutines.launch

class PrestameoViewModel : ViewModel() {
    private val data: PrestameoData = PrestameoData()

    fun add(prestameo: Prestameo, clientId:String){
       viewModelScope.launch {
           data.add(prestameo,clientId)
       }
    }
}