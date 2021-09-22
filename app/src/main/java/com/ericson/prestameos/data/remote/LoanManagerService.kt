package com.ericson.prestameos.data.remote

import com.ericson.prestameos.data.models.ResponseClients
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoanManagerService {
    @GET("api/v1/Clients")
    suspend fun getClients(): List<ResponseClients>

    @POST("api/v1/clients")
    suspend fun addClients(@Body clients: ResponseClients):ResponseClients
}