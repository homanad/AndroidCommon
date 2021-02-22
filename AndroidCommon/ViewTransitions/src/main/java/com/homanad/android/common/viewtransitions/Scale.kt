package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues

open class Scale(
    protected val startX: Float,
    protected val startY: Float,
    protected val endX: Float,
    protected val endY: Float,
    protected val pivotX: Float,
    protected val pivotY: Float,
    animDuration: Long = 300L
) : DefaultScale(animDuration) {

    override fun onAppear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        return createAnimation(view, startX, startY, endX, endY, pivotX, pivotY)
    }

    override fun onDisappear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        return createAnimation(view, startX, startY, endX, endY, pivotX, pivotY)
    }
}