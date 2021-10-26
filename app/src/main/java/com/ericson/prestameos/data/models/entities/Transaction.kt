package com.ericson.prestameos.data.models.entities

import androidx.room.Entity

@Entity
data class Transaction(
        val Id:Int,
        val IdPrestameo:Int,
        val IdCliente:Int,
        val amount:Int
)
