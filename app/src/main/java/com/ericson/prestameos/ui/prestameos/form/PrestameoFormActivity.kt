package com.ericson.prestameos.ui.prestameos.form

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.ericson.prestameos.R
import com.ericson.prestameos.data.models.entities.Prestameo
import com.ericson.prestameos.data.models.PrestameoType
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.databinding.ActivityPrestameoFormBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity
import com.ericson.prestameos.ui.prestameos.PrestameoViewModel
import com.ericson.prestameos.utils.Utils
import javax.inject.Inject

class PrestameoFormActivity : BaseActivity<ActivityPrestameoFormBinding>(ActivityPrestameoFormBinding::inflate) {

    @Inject lateinit var model:PrestameoViewModel
    var clientid:Int = 0

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }


    override fun setUp() {
        clientid = intent.getIntExtra("clientid", 0)

        val items = PrestameoType.values().map { it.text }

        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        (binding.sbType.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.btnAddPrestameo.setOnClickListener {
            addPrestameo()
        }

        model.message.observe(this,   {
                when(it){
                    is Result.Success -> {
                        Toast.makeText(this, "Creado Existosamente", Toast.LENGTH_SHORT).show()
                    }
                    is Result.Error -> {
                        Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show()
                    }
                }
        })
    }

    private fun addPrestameo(){
        val amount = binding.etAmount.editText?.text.toString()
        val description = binding.etDescription.editText?.text.toString()

        model.add(Prestameo(
            amount = amount.toDouble(),
            description = description,
            type = PrestameoType.UnknownPay,
            creationDate = Utils.getDate(),
            clientId = clientid,
            Balance = amount.toDouble()
        ))
    }

    override fun inject() {
        (application as App).appComponent.inject(this)
    }

}