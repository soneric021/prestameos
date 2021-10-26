package com.ericson.prestameos.data.models.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Relation
import com.ericson.prestameos.data.models.entities.Detail
import com.ericson.prestameos.data.models.entities.Prestameo
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrestameoDetail(
        @Embedded val prestameo: Prestameo,
        @Relation(
              parentColumn = "Id",
              entityColumn = "IdPrestameo"
      ) val detail: Detail
):Parcelable
