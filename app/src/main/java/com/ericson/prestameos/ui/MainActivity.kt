package com.ericson.prestameos.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ericson.prestameos.ui.client.ClientViewModel
import com.ericson.prestameos.databinding.ActivityMainBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity
import com.ericson.prestameos.ui.client.ClientAdapter
import com.ericson.prestameos.ui.client.ClientFormActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private val clAdapter: ClientAdapter = ClientAdapter(this,listOf())
    @Inject lateinit var model: ClientViewModel

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setUp() {
        binding.btnAddClients.setOnClickListener {
            startActivity(Intent(this,ClientFormActivity::class.java))
        }
        binding.rvClients.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = clAdapter
        }
        model.dataloading.observe(this, Observer {
            if(it){
                binding.progressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.INVISIBLE
            }
        })
        model.get().observe(this, Observer{
            clAdapter.submitList(it)
        })

    }

    override fun inject() {
        (application as App).appComponent.inject(this)
    }

}