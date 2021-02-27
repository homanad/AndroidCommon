package com.homanad.android.common.extensions.context

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.WindowManager
import java.util.*

@Suppress("DEPRECATION")
val Context.screenSize: Point
    get() {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val size = Point()
        display.getSize(size)
        return size
    }

val Any.deviceName: String
    get() {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return if (model.startsWith(manufacturer))
            model.capitalize(Locale.getDefault())
        else
            manufacturer.capitalize(Locale.getDefault()) + " " + model
    }