package com.ericson.prestameos.ui.client

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ericson.prestameos.data.models.entities.Client
import com.ericson.prestameos.data.models.Tables
import com.ericson.prestameos.databinding.ActivityClientBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity
import com.ericson.prestameos.ui.prestameos.PrestameoAdapter
import com.ericson.prestameos.ui.prestameos.form.PrestameoFormActivity
import javax.inject.Inject

class ClientActivity : BaseActivity<ActivityClientBinding>(ActivityClientBinding::inflate) {
    private val prAdapter:PrestameoAdapter = PrestameoAdapter(this,listOf())
    @Inject
    lateinit var model:ClientViewModel

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setUp() {
        binding.rvPrestemos.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = prAdapter
        }

        val client = intent.getParcelableExtra<Client>(Tables.CLIENTE)
        binding.tvname.text = client?.names

        binding.btnAddPrestameo.setOnClickListener {
            startActivity(Intent(this, PrestameoFormActivity::class.java).putExtra("clientid", client?.id) )
        }
        model.get(client?.id ?: 0).observe(this, Observer {
           if(it.prestameo.isNotEmpty()){
               prAdapter.submitList(it.prestameo)
               val total = it.prestameo
                       .map { prestameo -> prestameo.amount }
                       .reduce { acc, d -> acc + d }.toString() + "0"
               binding.tvTotal.text = "RD\$$total"
           }
        })

    }

    override fun inject() {
        (application as App).appComponent.inject(this)
    }


}