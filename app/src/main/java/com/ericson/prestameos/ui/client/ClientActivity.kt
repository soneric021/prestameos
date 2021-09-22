package com.ericson.prestameos.ui.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ericson.prestameos.data.models.Client
import com.ericson.prestameos.data.models.Tables
import com.ericson.prestameos.databinding.ActivityClientBinding

class ClientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityClientBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClientBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val client = intent.getParcelableExtra<Client>(Tables.CLIENTE)
        binding.tvNameClient.text = client?.name
    }
}