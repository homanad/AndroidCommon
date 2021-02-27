package com.homanad.android.common.extensions.view.animator

import android.animation.Animator
import android.view.View
import android.view.ViewAnimationUtils

fun createRevealAnimator(
    view: View,
    centerX: Int,
    centerY: Int,
    startRadius: Float,
    endRadius: Float
): Animator {
    return ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius)
}