package com.ericson.prestameos.data.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Detail(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val IdPrestameo:Int,
    val interest: Double?,
    val fee:Double?,
    val totalFees:Int?
) : Parcelable
