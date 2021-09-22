package com.ericson.prestameos.data

import android.util.Log
import com.ericson.prestameos.data.models.Prestameo
import com.ericson.prestameos.data.models.Tables
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class PrestameoData  {
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()
     suspend fun add(obj: Prestameo, clientId:String): Boolean {
       return try {
           db.collection(Tables.CLIENTE).document(clientId).collection(Tables.PRESTAMEO).add(obj).await()
           true
       }catch (e:Exception){
           Log.e("cliente", e.message, e)
           false
       }
    }

     suspend fun get( clientId:String): List<Prestameo>? {
         return try {
             db.collection(Tables.CLIENTE).document(clientId).collection(Tables.PRESTAMEO).get().await().toObjects(Prestameo::class.java)
         }catch (e:Exception){
             Log.e("cliente", e.message, e)
             null
         }
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