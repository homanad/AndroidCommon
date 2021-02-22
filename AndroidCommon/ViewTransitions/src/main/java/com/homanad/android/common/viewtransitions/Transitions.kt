package com.homanad.android.common.viewtransitions

import android.animation.Animator
import android.animation.AnimatorSet
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionValues
import androidx.transition.Visibility

class Transitions : Visibility {

    private var visibility: Collection<Visibility>
    private var animDuration: Long
    private var isPlayedSequentially: Boolean

    constructor(
        vararg visibility: Visibility,
        animDuration: Long = -1L,
        isPlayedSequentially: Boolean = false
    ) : super() {
        this.visibility = visibility.toList()
        this.animDuration = animDuration
        this.isPlayedSequentially = isPlayedSequentially
    }

    constructor(
        visibility: Collection<Visibility>,
        animDuration: Long = -1L,
        isPlayedSequentially: Boolean = false
    ) : super() {
        this.visibility = visibility
        this.animDuration = animDuration
        this.isPlayedSequentially = isPlayedSequentially
    }

    override fun onAppear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val animators = visibility.map { it.onAppear(sceneRoot, view, startValues, endValues) }

        return AnimatorSet().apply {
            if (isPlayedSequentially) playSequentially(animators)
            else playTogether(animators)
            if (animDuration != -1L) duration = animDuration
        }
    }

    override fun onDisappear(
        sceneRoot: ViewGroup?,
        view: View?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator {
        val animators = visibility.map { it.onDisappear(sceneRoot, view, startValues, endValues) }

        return AnimatorSet().apply {
            if (isPlayedSequentially) playSequentially(animators)
            else playTogether(animators)
            if (animDuration != -1L) duration = animDuration
        }
    }
}