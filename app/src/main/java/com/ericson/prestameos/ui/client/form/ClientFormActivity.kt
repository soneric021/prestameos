package com.ericson.prestameos.ui.client.form

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.Result
import com.ericson.prestameos.databinding.ActivityClientFormBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity
import com.ericson.prestameos.ui.client.ClientViewModel
import javax.inject.Inject

class ClientFormActivity : BaseActivity<ActivityClientFormBinding>(ActivityClientFormBinding::inflate) {

    @Inject
    lateinit var model: ClientViewModel

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setUp() {
        model.message.observe(this, Observer {
           when(it){
               is Result.Success -> {
                   Toast.makeText(this, "Creado Existosamente", Toast.LENGTH_SHORT).show()
                   binding.progressBar.visibility = View.INVISIBLE
               }
               is Result.Error -> {
                   Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show()
                   binding.progressBar.visibility = View.INVISIBLE
               }

           }
        })

        binding.button.setOnClickListener {
            addClient()
        }

    }

    private fun addClient(){
        val name = binding.etName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val address = binding.etAddress.text.toString()
        val tel = binding.etPhone.text.toString()
        val identifier = binding.etIdentifier.text.toString()

        val client = Client(
            names = name,
            lastNames = lastname,
            address = address,
            phoneNumber = tel,
            identifier = identifier
        )
        model.add(client)
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun inject() {
       (application as App).appComponent.inject(this)
    }
}