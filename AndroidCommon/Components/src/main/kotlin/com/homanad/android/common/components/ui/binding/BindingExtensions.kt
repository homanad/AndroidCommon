package com.homanad.android.common.components.ui.binding

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

fun <R : FragmentActivity, T : ViewDataBinding> contentView(
    @LayoutRes layoutRes: Int
): ContentViewBindingDelegate<R, T> = ContentViewBindingDelegate(layoutRes)

fun <T : ViewBinding> Fragment.inflateView(viewBindingFactory: (View) -> T) =
    InflateViewBindingDelegate(this, viewBindingFactory)