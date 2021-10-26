package com.ericson.prestameos.data.models.entities

import androidx.room.Embedded
import androidx.room.Relation
import com.ericson.prestameos.data.models.entities.Payments
import com.ericson.prestameos.data.models.entities.Prestameo


data class PrestameoPays(
        @Embedded val prestameo: Prestameo,
        @Relation(
        parentColumn = "Id",
        entityColumn = "IdPrestameos"
    )
    val payments: List<Payments>
)
