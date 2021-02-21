package com.homanad.android.common.extensions

import androidx.fragment.app.Fragment

/**Usage
 * val needToGet by getValue<Type>("key")
 */
inline fun <reified T : Any> Fragment.getValue(key: String, defaultValue: T? = null) = lazy {
    val value = arguments?.get(key)
    if (value is T) value else defaultValue
}

inline fun <reified T : Any> Fragment.getValueNonNull(key: String, defaultValue: T? = null) = lazy {
    val value = arguments?.get(key)
    requireNotNull(if (value is T) value else defaultValue) { key }
}