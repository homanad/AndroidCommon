package com.homanad.android.common.utilities

import android.view.View
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.transition.Slide
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis

fun getExitMaterialElevationScale(duration: Long) = MaterialElevationScale(false).apply {
    this.duration = duration
}

fun getReenterMaterialElevationScale(duration: Long) = MaterialElevationScale(true).apply {
    this.duration = duration
}

fun getEnterMaterialSharedAxisZ(duration: Long) =
    MaterialSharedAxis(MaterialSharedAxis.Z, true).apply {
        this.duration = duration
    }

fun getReturnMaterialSharedAxis(duration: Long) =
    MaterialSharedAxis(MaterialSharedAxis.Z, false).apply {
        this.duration = duration
    }

fun getReturnSlide(duration: Long, targetId: Int) = Slide().apply {
    this.duration = duration
    addTarget(targetId)
}

fun getEnterFadeThrough(duration: Long) = MaterialFadeThrough().apply {
    this.duration = duration
}

fun getSharedElementEnterMaterialContainerTransform(
    drawingViewId: Int,
    duration: Long,
    scrimColor: Int,
    allContainerColor: Int
) = MaterialContainerTransform().apply {
    this.drawingViewId = drawingViewId
    this.duration = duration
    this.scrimColor = scrimColor
    setAllContainerColors(allContainerColor)
}

fun Fragment.drawReenterTransition(view: View) {
    postponeEnterTransition()
    view.doOnPreDraw { startPostponedEnterTransition() }
}