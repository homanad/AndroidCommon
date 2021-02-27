package com.homanad.android.common.extensions.context

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showAlertDialog(
    positiveButtonText: String,
    title: String,
    message: String,
    cancelable: Boolean = false,
    action: () -> Unit
) {
    val dialog = AlertDialog.Builder(this)
        .setTitle(title)
        .setMessage(message)
        .setCancelable(cancelable)
        .setPositiveButton(positiveButtonText) { dialog, _ ->
            dialog.cancel()
            action()
        }.create()
    dialog.show()
}