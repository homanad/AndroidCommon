package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues

/**
 *#pivot range: 0f(top) - 1f(bot)
 **/
class ScaleY(
    startY: Float,
    endY: Float,
    pivotY: Float
) : Scale(1f, startY, 1f, endY, 0f, pivotY) {

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