package com.homanad.android.common.extensions.window

import android.graphics.Point
import android.view.Window

@Suppress("DEPRECATION")
fun Window.scaleWidth(scaleRatio: Float) {
    val params = attributes
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    params.width =
        (size.x * scaleRatio).toInt()
    attributes = params
}

@Suppress("DEPRECATION")
fun Window.scaleHeight(scaleRatio: Float) {
    val params = attributes
    val display = windowManager.defaultDisplay
    val size = Point()
    display.getSize(size)
    params.height =
        (size.y * scaleRatio).toInt()
    attributes = params
}