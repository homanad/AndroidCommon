package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues

open class Rotate(
    private val fromDegrees: Float,
    private val toDegrees: Float,
    private val pivotX: Float,
    private val pivotY: Float
) : DefaultRotate() {

    override fun onAppear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        return createAnimation(view, fromDegrees, toDegrees, pivotX, pivotY)
    }

    override fun onDisappear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        return createAnimation(view, fromDegrees, toDegrees, pivotX, pivotY)
    }
}