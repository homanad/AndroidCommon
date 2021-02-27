package com.homanad.android.common.extensions.view

import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.homanad.android.common.extensions.view.animator.createRevealAnimator

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.showShortSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_SHORT).show()
}

fun View.showLongSnackbar(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).show()
}

fun View.snackBarWithAction(
    message: String, actionLabel: String,
    action: () -> Unit
) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction(actionLabel) {
            action()
        }
}

fun View.startRevealAnimation(centerX: Int, centerY: Int, startRadius: Float, endRadius: Float) {
    createRevealAnimator(this, centerX, centerY, startRadius, endRadius).start()
}