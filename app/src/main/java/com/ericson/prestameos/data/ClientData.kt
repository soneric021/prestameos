package com.ericson.prestameos.data

import android.util.Log
import com.ericson.prestameos.data.models.Client
import com.ericson.prestameos.data.models.Tables
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject

class ClientData @Inject constructor(private val db: FirebaseFirestore) {

    suspend fun add(obj: Client):Boolean {
            return try{
                Log.d("cliente", "creada")
                db.collection(Tables.CLIENTE).add(obj).await()
                true
            }catch(e:Exception){
                Log.e("cliente", e.message, e)
                false
            }
        }

    suspend fun get(): List<Client>? {
            return try {
                db.collection(Tables.CLIENTE).get().await().toObjects(Client::class.java)
            }catch (e:Exception){
                Log.e("cliente", "Error", e)
                null
            }

        }

         fun getById(): Client {
                TODO("Not yet implemented")
        }

         fun update(obj: Client) {
                TODO("Not yet implemented")
        }

         fun delete(obj: Client) {
                TODO("Not yet implemented")
        }


}