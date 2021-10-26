package com.ericson.prestameos.data.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity
data class Payments(
        @PrimaryKey(autoGenerate = true) val Id:Int = 0,
        var IdPrestameo:Int,
        var amount:Double,
        var numberFee:Int?,
        var interest:Double?,
        var paymentDate:Date
):Parcelable
