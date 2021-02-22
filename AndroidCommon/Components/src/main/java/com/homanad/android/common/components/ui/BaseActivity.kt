package com.homanad.android.common.components.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding(savedInstanceState)
        updateUI()
        observeData()
    }

    abstract fun setupBinding(savedInstanceState: Bundle?)

    abstract fun updateUI()

    abstract fun observeData()
}