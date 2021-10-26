package com.ericson.prestameos.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo

@Dao
interface ClientDao {
    @Query("SELECT * FROM client")
    fun getAll():LiveData<List<Client>>

    @Query("SELECT * FROM client where id = :Id")
    suspend fun get(Id:Int): Client

    @Transaction
    @Query("SELECT * FROM client where id = :Id")
    fun getWithPrestameos(Id: Int):LiveData<ClientWithPrestameo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(client: Client)

    @Insert
    suspend fun insertAll(vararg client: Client)

    @Delete
    suspend fun delete(client: Client)
}