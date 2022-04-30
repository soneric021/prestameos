package com.ericson.prestameos.ui

import com.ericson.prestameos.databinding.ActivityMainBinding
import com.ericson.prestameos.di.App
import com.ericson.prestameos.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setUp() {


    }

    override fun inject() {
        (application as App).appComponent.inject(this)
    }

}