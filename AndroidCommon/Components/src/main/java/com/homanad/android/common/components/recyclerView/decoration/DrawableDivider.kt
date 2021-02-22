package com.homanad.android.common.components.recyclerView.decoration

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration

class DrawableDivider(
    private val context: Context,
    private val orientation: Int,
    @DrawableRes private val drawableId: Int
) : Divider(context, orientation) {

    override fun invoke(): DividerItemDecoration {
        val divider = DividerItemDecoration(context, orientation)
        divider.setDrawable(ContextCompat.getDrawable(context, drawableId)!!)
        return this
    }
}