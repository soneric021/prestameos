package com.ericson.prestameos.data

import com.ericson.prestameos.data.local.LoanDatabase
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.data.models.Result
import java.lang.Exception
import javax.inject.Inject


class PrestameoData  @Inject constructor( private val loanDatabase: LoanDatabase)  {

     suspend fun add(obj: Prestameo): Result<Boolean> {
     return try{
         loanDatabase.loanDao().save(obj)
         Result.Success(true)
     }catch (e:Exception){
         Result.Error(e)
     }
    }

     suspend fun get( clientId:String): List<Prestameo>? {
       TODO()
    }

     fun getById(): Prestameo {
        TODO("Not yet implemented")
    }

     fun update(obj: Prestameo) {
        TODO("Not yet implemented")
    }

     fun delete(obj: Prestameo) {
        TODO("Not yet implemented")
    }
}