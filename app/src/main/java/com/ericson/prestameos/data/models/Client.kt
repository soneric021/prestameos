package com.ericson.prestameos.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Client(
        val name: String = "",
        val cedula:String = "",
        val prestameos: List<Prestameo> = listOf()
):Parcelable