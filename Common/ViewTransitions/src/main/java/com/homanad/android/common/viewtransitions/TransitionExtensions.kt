package com.homanad.android.common.viewtransitions

import androidx.transition.TransitionValues

fun TransitionValues?.getValueByPropName(
    propName: String,
    fallbackValue: Float
): Float {
    return this?.values?.get(propName) as? Float ?: fallbackValue
}

fun Int.getPivot(ratio: Float) = this * ratio