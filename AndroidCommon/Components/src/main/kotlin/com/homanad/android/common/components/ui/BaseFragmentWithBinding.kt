package com.homanad.android.common.components.ui

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragmentWithBinding(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    protected abstract val binding: ViewBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        updateUI()
        observeData()
    }

    protected abstract fun setupViewModel()
    protected abstract fun updateUI()
    protected abstract fun observeData()
}