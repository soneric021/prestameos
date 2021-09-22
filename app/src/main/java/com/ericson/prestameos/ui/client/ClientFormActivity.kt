package com.ericson.prestameos.ui.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ericson.prestameos.R
import com.ericson.prestameos.databinding.ActivityClientFormBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity

class ClientFormActivity : BaseActivity<ActivityClientFormBinding>(ActivityClientFormBinding::inflate) {


    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setUp() {

    }

    override fun inject() {
       (application as App).appComponent.inject(this)
    }
}