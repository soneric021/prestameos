package com.ericson.prestameos.di

import android.content.Context
import com.ericson.prestameos.ui.client.ClientActivity
import com.ericson.prestameos.ui.MainActivity
import com.ericson.prestameos.ui.client.ClientFormActivity
import com.google.firebase.firestore.FirebaseFirestore
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent


    }
    val db:FirebaseFirestore

    fun inject(activity: MainActivity)
    fun inject(activity: ClientActivity)
    fun inject(activity: ClientFormActivity)
}