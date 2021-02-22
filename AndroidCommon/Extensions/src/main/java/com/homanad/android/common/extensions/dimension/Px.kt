package com.homanad.android.common.extensions.dimension

import android.content.res.Resources

val Float.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()