package com.ericson.prestameos.data.models.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Client(
        val address: String,
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val identifier: String,
        val lastNames: String,
        val names: String,
        var nickName: String = "",
        val phoneNumber: String,
        val photo: String = ""
):Parcelable