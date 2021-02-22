package com.homanad.android.common.components.recyclerView.decoration

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration

class DrawableItemDivider(
    context: Context,
    orientation: Int,
    @DrawableRes drawableId: Int
) : DividerItemDecoration(context, orientation) {
    init {
        setDrawable(ContextCompat.getDrawable(context, drawableId)!!)
    }
}