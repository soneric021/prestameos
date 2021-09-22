package com.ericson.prestameos.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PrestameoDetail(
        val interest: Double?,
        val fee:Double?,
        val totalFees:Int?
):Parcelable
