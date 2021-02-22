package com.homanad.android.common.components.recyclerView.snapHelper

interface OnSnapPositionChangeListener {

    fun onSnapPositionChanged(position: Int)

    fun onSnapScrolling(isScrolling: Boolean)
}