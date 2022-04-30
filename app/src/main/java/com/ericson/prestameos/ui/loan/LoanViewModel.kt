package com.ericson.prestameos.ui.loan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.ClientData
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoanViewModel @Inject constructor( private val clientData:ClientData) : ViewModel() {
    val clients:LiveData<List<ClientWithPrestameo>> by lazy { getClientsFromDb() }

    private fun getClientsFromDb():LiveData<List<ClientWithPrestameo>>{
         return clientData.get()
    }
    fun add(client: Client){
        viewModelScope.launch {
            clientData.add(client)
        }
    }
}