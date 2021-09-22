package com.ericson.prestameos.data.remote

import android.util.Log
import com.ericson.prestameos.data.models.ResponseClients
import com.ericson.prestameos.data.models.Result
import java.lang.Exception
import javax.inject.Inject


class ClientRepository @Inject constructor(private val loanManagerService: LoanManagerService) {

    suspend fun get():Result<List<ResponseClients>>{
        return Result.Success(loanManagerService.getClients())
    }

    suspend fun add(client: ResponseClients):Result<ResponseClients>{
       return try {
            val c = loanManagerService.addClients(client)
            Result.Success(c)
        }catch (e:Exception){
            Log.e("Client", e.message ?: "error", e)
            Result.Error(e)
        }
    }
}