package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues

/**
 *#pivot range: 0f(start) - 1f(end)
 **/
class ScaleX(
    startX: Float,
    endX: Float,
    pivotX: Float
) : Scale(startX, 1f, endX, 1f, pivotX, 0f) {

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