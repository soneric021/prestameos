package com.ericson.prestameos.data.local

import androidx.room.*
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.Payments
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.utils.Converters

@Database(entities = [Client::class, Prestameo::class, Payments::class], version = 5, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LoanDatabase : RoomDatabase() {
    abstract fun clientDao():ClientDao
    abstract fun loanDao():LoanDao
    abstract fun paymentDao():PaymentDao
}