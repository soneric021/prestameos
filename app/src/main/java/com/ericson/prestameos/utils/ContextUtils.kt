package com.ericson.prestameos.utils

import android.content.Context
import android.content.Intent

inline fun <reified Activity> Context.startActivity(intent: Intent){
    val i = Intent(this, Activity::class.java)
    this.startActivity(i)
}