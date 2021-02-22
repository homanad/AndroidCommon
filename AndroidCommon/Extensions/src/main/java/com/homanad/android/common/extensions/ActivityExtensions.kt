package com.homanad.android.common.extensions

import android.app.Activity

/**Usage
 * val needToGet by getValue<Type>("key", defaultValue)
 */
inline fun <reified T : Any> Activity.getValue(key: String, defaultValue: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    if (value is T) value else defaultValue
}

inline fun <reified T : Any> Activity.getValueNonNull(key: String, defaultValue: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    requireNotNull((if (value is T) value else defaultValue)) { key }
}