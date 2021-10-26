package com.ericson.prestameos.data.models.entities

import androidx.room.Embedded
import androidx.room.Relation

data class ClientWithPrestameo(
        @Embedded val cliente: Client,
        @Relation(
                parentColumn = "id",
                entityColumn = "clientId"
        )
        val prestameo: List<Prestameo>
)
