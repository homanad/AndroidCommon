package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues
import androidx.transition.Visibility

open class DefaultRotate(private val animDuration: Long = 300L) : Visibility() {

    protected fun createAnimation(
        view: View?,
        fromDegrees: Float,
        toDegrees: Float,
        pivotX: Float,
        pivotY: Float
    ): Animator {
        view?.let {
            it.pivotX = it.measuredWidth.getPivot(pivotX)
            it.pivotY = it.measuredHeight.getPivot(pivotY)
        }
        return ObjectAnimator.ofFloat(view, View.ROTATION, fromDegrees, toDegrees).apply {
            duration = animDuration
            start()
        }
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        super.captureStartValues(transitionValues)
        transitionValues.values[PROPNAME_TRANSITION_ROTATION] = transitionValues.view.rotation
    }

    override fun onAppear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val fromDegrees = startValues.getValueByPropName(PROPNAME_TRANSITION_ROTATION, 0f)
        return createAnimation(view, fromDegrees, 360f, 0.5f, 0.5f)
    }

    override fun onDisappear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val fromDegrees = startValues.getValueByPropName(PROPNAME_TRANSITION_ROTATION, 0f)
        return createAnimation(view, fromDegrees, 0f, 0.5f, 0.5f)
    }

    companion object {
        private const val PROPNAME_TRANSITION_ROTATION =
            "com.homanad.android.customtransition:Rotate:rotation"
    }
}