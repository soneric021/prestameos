package com.ericson.prestameos.data.models


data class ResponseClients(
    val address: String,
    val id: Int,
    val identifier: String,
    val lastNames: String,
    val names: String,
    val nickName: String,
    val phoneNumber: String,
    val photo: String
)