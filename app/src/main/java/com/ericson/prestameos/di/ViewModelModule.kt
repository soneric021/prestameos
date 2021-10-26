package com.ericson.prestameos.di

import com.ericson.prestameos.ui.client.ClientViewModel
import com.ericson.prestameos.ui.payment.PaymentViewModel
import com.ericson.prestameos.ui.prestameos.PrestameoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(ClientViewModel::class)
    abstract fun bindClientViewModel(viewmodel: ClientViewModel): ClientViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PrestameoViewModel::class)
    abstract fun bindPrestameoViewModel(viewmodel: PrestameoViewModel): PrestameoViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PaymentViewModel::class)
    abstract fun bindPaymentViewModel(viewmodel: PaymentViewModel): PaymentViewModel

}