package com.ericson.prestameos.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Prestameo(val description: String = "",
                     val amount:Double = 0.0,
                     val type: PrestameoType,
                     val creationDate:Date,
                     val paymentDate: Date?,
                     val paid:Boolean,
                     val prestameoDetail:PrestameoDetail,
                     val pays:List<Payments>
                     ):Parcelable

