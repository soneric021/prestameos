package com.ericson.prestameos.ui.payment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ericson.prestameos.data.PaymentData
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.data.models.entities.Payments
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaymentViewModel @Inject constructor(private val paymentData: PaymentData) : ViewModel() {
    private val _message = MutableLiveData<Result<Boolean>>()
    val message: LiveData<Result<Boolean>> = _message

    fun pay(payments: Payments){
        viewModelScope.launch(Dispatchers.IO) {
            _message.postValue(paymentData.pay(payments))
        }
    }
}