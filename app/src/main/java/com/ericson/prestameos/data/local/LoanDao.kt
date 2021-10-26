package com.ericson.prestameos.data.local

import androidx.room.*
import com.ericson.prestameos.data.models.entities.Prestameo

@Dao
interface LoanDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(prestameo: Prestameo)

    @Update
    suspend fun update(prestameo: Prestameo)

    @Query("SELECT * FROM loan where Id = :Id")
    suspend fun getById(Id:Int):Prestameo
}