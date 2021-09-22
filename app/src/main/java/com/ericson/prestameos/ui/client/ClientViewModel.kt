package com.ericson.prestameos.ui.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.ClientData
import com.ericson.prestameos.data.models.Client
import com.ericson.prestameos.data.models.ResponseClients
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.data.remote.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class ClientViewModel @Inject constructor(val data: ClientData, val dataN: ClientRepository) : ViewModel() {

    private val clients:MutableLiveData<List<Client>> = MutableLiveData()
    private val clientsN = MutableLiveData<List<ResponseClients>>()
    private val _dataLoading = MutableLiveData<Boolean>()
    val dataloading:LiveData<Boolean> = _dataLoading
    private  val _message = MutableLiveData<String>()
    private val message:LiveData<String> = _message
    init {
        viewModelScope.launch {
            //clients.value = data.get()
           dataN.get().let {
               when(it){
                   is Result.Success -> {
                       _dataLoading.value = false
                       clientsN.postValue(it.data!!)
                   }
                   else -> _dataLoading.value = true
               }
           }
        }
    }
    fun get():LiveData<List<ResponseClients>>{
        return clientsN
    }

    fun add(client:ResponseClients){
        viewModelScope.launch(Dispatchers.IO) {
           dataN.add(client).let {
             when(it){
                 is Result.Success -> {
                     _dataLoading.value = false
                     _message.value = "Cliente creado exitosasmente"
                 }
                 is Result.Error -> {
                     _dataLoading.value = false
                     _message.value = it.exception.message ?: "un error"
                 }
                 else -> _dataLoading.value = true
             }
           }
        }
    }

}