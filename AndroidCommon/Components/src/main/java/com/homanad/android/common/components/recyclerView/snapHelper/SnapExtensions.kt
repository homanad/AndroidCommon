package com.homanad.android.common.components.recyclerView.snapHelper

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    if (recyclerView.childCount == 0) return EMPTY_POSITION
    val layoutManager = recyclerView.layoutManager
    val snapView = findSnapView(layoutManager) ?: return EMPTY_POSITION
    return layoutManager?.getPosition(snapView) ?: EMPTY_POSITION
}

const val EMPTY_POSITION = -1