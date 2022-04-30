package com.ericson.prestameos.di

import android.content.Context
import com.ericson.prestameos.ui.MainActivity
import com.ericson.prestameos.ui.loan.LoanFragment
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

    fun inject(fragment:LoanFragment)
    fun inject(activity: MainActivity)
}