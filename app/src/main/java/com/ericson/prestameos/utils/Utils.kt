package com.ericson.prestameos.utils

import java.util.*
import kotlin.random.Random

object Utils {
    fun generateNickName(name:String):String{
        return name + "#" + Random.nextInt(0,1000)
    }
    fun getDate():Date{
        return Calendar.getInstance().time
    }
    fun getPesos(amount:Double?):String{
        return if(amount == null){
            "0.00"
        }else{
            "RD$" + amount + "0"
        }
    }
}