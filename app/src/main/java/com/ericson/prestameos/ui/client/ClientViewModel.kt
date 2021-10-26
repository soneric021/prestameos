package com.ericson.prestameos.ui.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.ClientData
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo
import com.ericson.prestameos.data.models.ResponseClients
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.data.remote.ClientRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class ClientViewModel @Inject constructor(val data: ClientData, val dataN: ClientRepository) : ViewModel() {

    private var  clients:LiveData<List<Client>> = data.get()
    private val clientsN = MutableLiveData<List<ResponseClients>>()
    private val _dataLoading = MutableLiveData<Boolean>()
    private lateinit var client:LiveData<ClientWithPrestameo>
    val dataloading:LiveData<Boolean> = _dataLoading
    private val _message = MutableLiveData<Result<Boolean>>()
    val message:LiveData<Result<Boolean>> = _message

    fun get(clienId: Int):LiveData<ClientWithPrestameo>{
        client = data.getById(clienId)
        return client
    }
    fun get():LiveData<List<Client>>{
        return clients
    }

    fun add(client: Client){
        viewModelScope.launch {
           data.add(client).let {
                _message.value = it
           }
        }
    }

}