package com.ericson.prestameos.data

interface IServiceData<T> {
    suspend fun add(obj:T):T? {return null}
    suspend fun add(obj: T, clientId:String):T? {return null}
    suspend fun get():List<T>?
    fun getById():T
    fun update(obj: T)
    fun delete(obj: T)
}