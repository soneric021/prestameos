package com.ericson.prestameos.di


import com.ericson.prestameos.ui.loan.LoanViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoanViewModel::class)
    abstract fun bindLoanViewModel(viewmodel: LoanViewModel): LoanViewModel
}