package com.ericson.prestameos.data.local

import androidx.room.Dao
import androidx.room.Insert
import com.ericson.prestameos.data.models.entities.Payments

@Dao
interface PaymentDao {
    @Insert
    suspend fun save(payments: Payments)
}