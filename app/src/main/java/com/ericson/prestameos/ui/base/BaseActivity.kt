package com.ericson.prestameos.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B: ViewBinding>(val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity() {


    protected val binding: B by lazy { bindingFactory(layoutInflater) }

    @LayoutRes
    protected abstract fun getLayout():Int

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUp()
    }

    abstract fun setUp()
    abstract fun inject()
}