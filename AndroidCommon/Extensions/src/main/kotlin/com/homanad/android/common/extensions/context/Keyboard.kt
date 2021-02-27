package com.homanad.android.common.extensions.context

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.dismissKeyboard(view: View) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(view: View, delay: Long) {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    view.postDelayed({
        view.requestFocus()
        imm.showSoftInput(view, 0)
    }, delay)
}