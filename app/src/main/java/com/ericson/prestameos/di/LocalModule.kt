package com.ericson.prestameos.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ericson.prestameos.data.ClientData
import com.ericson.prestameos.data.PaymentData
import com.ericson.prestameos.data.PrestameoData
import com.ericson.prestameos.data.local.ClientDao
import com.ericson.prestameos.data.local.LoanDao
import com.ericson.prestameos.data.local.LoanDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context):LoanDatabase = Room.databaseBuilder(
            context.applicationContext,
            LoanDatabase::class.java, "loan_database"
    ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideClientDao(loanDatabase: LoanDatabase):ClientDao = loanDatabase.clientDao()

    @Provides
    fun provideLoanDao(loanDatabase: LoanDatabase):LoanDao = loanDatabase.loanDao()

    @Provides
    fun provideClientData(loanDatabase: LoanDatabase): ClientData = ClientData(loanDatabase)

    @Provides
    fun providePrestameoData(loanDatabase: LoanDatabase):PrestameoData = PrestameoData(loanDatabase)

    @Provides
    fun providePaymentData(loanDatabase: LoanDatabase):PaymentData = PaymentData(loanDatabase)
}