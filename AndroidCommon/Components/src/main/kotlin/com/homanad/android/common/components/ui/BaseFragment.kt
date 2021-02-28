package com.homanad.android.common.components.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
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