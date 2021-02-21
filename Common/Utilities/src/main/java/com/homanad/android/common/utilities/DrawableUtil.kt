package com.homanad.android.common.utilities

import android.graphics.drawable.GradientDrawable

object DrawableUtil {

    fun createGradientDrawable(
        startColor: Int,
        endColor: Int,
        shape: Int,
        orientation: GradientDrawable.Orientation = GradientDrawable.Orientation.BL_TR,
        gradientType: Int = GradientDrawable.LINEAR_GRADIENT,
        strokeColor: Int = 0,
        strokeWidth: Int = 0
    ): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        val colors = intArrayOf(startColor, endColor)
        gradientDrawable.colors = colors
        gradientDrawable.shape = shape
        gradientDrawable.orientation = orientation
        gradientDrawable.setStroke(strokeWidth, strokeColor)
        gradientDrawable.gradientType = gradientType
        return gradientDrawable
    }
}