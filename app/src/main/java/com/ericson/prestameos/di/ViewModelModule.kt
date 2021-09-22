package com.ericson.prestameos.di

import com.ericson.prestameos.ui.client.ClientViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ClientViewModel::class)
    abstract fun bindClientViewModel(viewmodel: ClientViewModel): ClientViewModel
}