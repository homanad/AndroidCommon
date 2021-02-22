package com.homanad.android.common.components.recyclerView.snapHelper

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class SnapOnScrollListener(
    private val snapHelper: SnapHelper,
    var onSnapPositionChangeListener: OnSnapPositionChangeListener
) : RecyclerView.OnScrollListener() {
    private var mSnapPosition = RecyclerView.NO_POSITION

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        maybeNotifySnapPositionChange(recyclerView)
        if (recyclerView.scrollState == RecyclerView.SCROLL_STATE_IDLE)
            onSnapPositionChangeListener.onSnapScrolling(false)
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        if (snapPosition != EMPTY_POSITION)
            onSnapPositionChangeListener.onSnapScrolling(false)
    }

    private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        val snapPositionChanged = mSnapPosition != snapPosition
        if (snapPositionChanged && snapPosition != EMPTY_POSITION) {
            onSnapPositionChangeListener.onSnapPositionChanged(snapPosition)
            onSnapPositionChangeListener.onSnapScrolling(true)
            mSnapPosition = snapPosition
        }
    }
}
