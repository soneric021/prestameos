package com.ericson.prestameos.data

import android.util.Log
import androidx.lifecycle.LiveData
import com.ericson.prestameos.data.local.LoanDatabase
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.entities.ClientWithPrestameo
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.utils.Utils
import java.lang.Exception
import javax.inject.Inject

class ClientData @Inject constructor(private val db: LoanDatabase) {

    suspend fun add(obj: Client):Result<Boolean> {
            return try{
                obj.nickName = Utils.generateNickName(obj.names)
                db.clientDao().save(obj)
                Result.Success(true)
            }catch(e:Exception){
                Log.e("cliente", e.message, e)
                Result.Error(e)
            }
        }

        fun get(): LiveData<List<Client>> {
           return db.clientDao().getAll()
        }

        fun getById(id:Int):LiveData<ClientWithPrestameo>  {
               return db.clientDao().getWithPrestameos(id)
        }

         fun update(obj: Client) {
                TODO("Not yet implemented")
        }

         fun delete(obj: Client) {
                TODO("Not yet implemented")
        }


}