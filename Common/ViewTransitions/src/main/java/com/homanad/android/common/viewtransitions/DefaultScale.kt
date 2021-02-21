package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues
import androidx.transition.Visibility

open class DefaultScale : Visibility() {

    protected fun createAnimation(
        view: View?,
        startScaleX: Float,
        startScaleY: Float,
        endScaleX: Float,
        endScaleY: Float,
        pivotX: Float,
        pivotY: Float
    ): Animator {
        val animScaleX = ObjectAnimator.ofFloat(view, View.SCALE_X, startScaleX, endScaleX)
        val animScaleY = ObjectAnimator.ofFloat(view, View.SCALE_Y, startScaleY, endScaleY)
        view?.let {
            it.pivotX = it.measuredWidth.getPivot(pivotX)
            it.pivotY = it.measuredHeight.getPivot(pivotY)
        }

        val animator = AnimatorSet()
        animator.playTogether(animScaleX, animScaleY)
        return animator
    }

    override fun captureStartValues(transitionValues: TransitionValues) {
        super.captureStartValues(transitionValues)
        transitionValues.values[PROPNAME_TRANSITION_SCALE_X] = transitionValues.view.scaleX
        transitionValues.values[PROPNAME_TRANSITION_SCALE_Y] = transitionValues.view.scaleY
    }

    override fun onAppear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val startScaleX = startValues.getValueByPropName(PROPNAME_TRANSITION_SCALE_X, 0f)
        val startScaleY = startValues.getValueByPropName(PROPNAME_TRANSITION_SCALE_Y, 0f)
        return createAnimation(view, startScaleX, startScaleY, 1f, 1f, 0.5f, 0.5f)
    }

    override fun onDisappear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val startScaleX = startValues.getValueByPropName(PROPNAME_TRANSITION_SCALE_X, 1f)
        val startScaleY = startValues.getValueByPropName(PROPNAME_TRANSITION_SCALE_Y, 1f)
        return createAnimation(view, startScaleX, startScaleY, 0f, 0f, 0.5f, 0.5f)
    }

    companion object {
        private const val PROPNAME_TRANSITION_SCALE_X =
            "com.homanad.android.customtransition:Scale:scaleX"
        private const val PROPNAME_TRANSITION_SCALE_Y =
            "com.homanad.android.customtransition:Scale:scaleY"
    }
}