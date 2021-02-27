package com.homanad.android.common.extensions.resource

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat

fun Int.asColor(context: Context) = ContextCompat.getColor(context, this)

fun Int.asDrawable(context: Context) = ContextCompat.getDrawable(context, this)

fun Int.asString(context: Context) = context.getString(this)

fun Int.asAnimation(context: Context): Animation = AnimationUtils.loadAnimation(context, this)