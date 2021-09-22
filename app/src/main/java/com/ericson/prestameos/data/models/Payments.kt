package com.ericson.prestameos.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class Payments(
        var amount:Double,
        var numberFee:Int?,
        var interest:Double?,
        var paymentDate:Date
):Parcelable
