package com.ericson.prestameos.di

import com.ericson.prestameos.data.ClientData
import com.ericson.prestameos.data.remote.LoanManagerService
import com.ericson.prestameos.BuildConfig
import com.ericson.prestameos.data.remote.ClientRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideFireStore():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    fun provideClientData(firebaseFirestore: FirebaseFirestore): ClientData = ClientData(firebaseFirestore)

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(OkHttpClient().newBuilder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideLoanManagerService(retrofit: Retrofit): LoanManagerService = retrofit.create(LoanManagerService::class.java)

    @Provides
    fun provideClientRepository(loanManagerService: LoanManagerService): ClientRepository = ClientRepository(loanManagerService)
}