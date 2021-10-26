package com.ericson.prestameos.di

import android.content.Context
import com.ericson.prestameos.ui.client.ClientActivity
import com.ericson.prestameos.ui.MainActivity
import com.ericson.prestameos.ui.client.form.ClientFormActivity
import com.ericson.prestameos.ui.payment.PaymentDialogFragment
import com.ericson.prestameos.ui.prestameos.form.PrestameoFormActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class, LocalModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent


    }

    fun inject(activity: MainActivity)
    fun inject(activity: ClientActivity)
    fun inject(activity:PrestameoFormActivity)
    fun inject(fragment: PaymentDialogFragment)
    fun inject(activity: ClientFormActivity)
}