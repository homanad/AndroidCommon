package com.homanad.android.common.components.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivityWithBinding : AppCompatActivity() {

    protected abstract val binding: ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateUI()
        observeData()
    }

    protected abstract fun updateUI()

    protected abstract fun observeData()
}