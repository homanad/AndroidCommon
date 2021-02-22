package com.homanad.android.common.components.recyclerView.decoration

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration

/**
 * Creates a divider {@link RecyclerView.ItemDecoration} that can be used with a
 * {@link LinearLayoutManager}.
 *
 * @param context Current context, it will be used to access resources.
 * @param orientation Divider orientation. LinearLayout.HORIZONTAL or LinearLayout.VERTICAL.
 */
abstract class Divider(private val context: Context, private val orientation: Int) :
    DividerItemDecoration(context, orientation) {

    abstract operator fun invoke(): DividerItemDecoration
}