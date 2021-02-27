package com.homanad.android.common.extensions.view

import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.homanad.android.common.extensions.view.animator.createRevealAnimator

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.showShortSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}

fun View.showShortSnackbar(@StringRes messageRes: Int) {
    Snackbar.make(this, messageRes, Snackbar.LENGTH_SHORT).show()
}

fun View.showLongSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun View.showLongSnackbar(@StringRes messageRes: Int) {
    Snackbar.make(this, messageRes, Snackbar.LENGTH_LONG).show()
}

fun View.showInfiniteSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).show()
}

fun View.showInfiniteSnackbar(@StringRes messageRes: Int) {
    Snackbar.make(this, messageRes, Snackbar.LENGTH_INDEFINITE).show()
}

fun View.snackBarWithAction(
    message: String,
    actionLabel: String,
    action: () -> Unit,
    length: Int = Snackbar.LENGTH_LONG
) {
    Snackbar.make(this, message, length)
        .setAction(actionLabel) { action() }
}

fun View.startRevealAnimation(centerX: Int, centerY: Int, startRadius: Float, endRadius: Float) {
    createRevealAnimator(this, centerX, centerY, startRadius, endRadius).start()
}