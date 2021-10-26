package com.ericson.prestameos.ui.payment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.data.models.entities.Payments
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.databinding.LayoutBottomPaymentBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.client.ClientActivity
import com.ericson.prestameos.utils.Utils
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

class PaymentDialogFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var model:PaymentViewModel

    private lateinit var prestameo: Prestameo

    lateinit var binding:LayoutBottomPaymentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  LayoutBottomPaymentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).appComponent.inject(this)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prestameo = arguments?.getParcelable<Prestameo>("prestameo")!!
        binding.etAmount.editText?.setText(prestameo.Balance.toString())
        binding.btnPay.setOnClickListener {
            pay()
        }
        model.message.observe(this, Observer {
            when(it){
                is Result.Success -> {
                    Toast.makeText(requireContext(), "Pago realizao existosamente", Toast.LENGTH_SHORT).show()

                }
                is Result.Error -> {
                    Toast.makeText(requireContext(), "Hubo un error", Toast.LENGTH_SHORT).show()
                }
                Result.Loading -> TODO()
            }
        })

    }
    private fun pay(){
        val amount = binding.etAmount.editText?.text.toString().toDouble()

        model.pay(Payments(
              amount = amount,
              numberFee = null,
              interest = null,
              paymentDate = Utils.getDate(),
              IdPrestameo = prestameo.Id
        ))
    }
    companion object {
        val TAG = "PaymentDialogFragment"
    }
}