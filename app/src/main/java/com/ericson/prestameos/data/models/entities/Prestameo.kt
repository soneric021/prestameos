package com.ericson.prestameos.data.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ericson.prestameos.data.models.PrestameoType
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "loan")
data class Prestameo(@PrimaryKey(autoGenerate = true) val Id:Int = 0,
                     val description: String,
                     val clientId:Int,
                     val amount:Double,
                     var Balance:Double,
                     val type: PrestameoType,
                     val creationDate:Date?,
                     val paymentDate: Date? = null,
                     val paid:Boolean? = false
                     ):Parcelable

