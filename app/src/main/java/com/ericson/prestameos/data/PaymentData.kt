package com.ericson.prestameos.data

import android.util.Log
import com.ericson.prestameos.data.local.LoanDatabase
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.data.models.entities.Payments
import java.lang.Exception
import javax.inject.Inject

class PaymentData @Inject constructor(private val loanDatabase: LoanDatabase) {
    suspend fun pay(payments: Payments):Result<Boolean>{
        return try {
            loanDatabase.paymentDao().save(payments)
            val loan = loanDatabase.loanDao().getById(payments.IdPrestameo)
            loan.Balance = loan.Balance - payments.amount
            loanDatabase.loanDao().update(loan)
            Result.Success(true)
        }catch (e:Exception){
            Log.e("Error", e.message, e)
            Result.Error(e)
        }
    }
}