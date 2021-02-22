package com.homanad.android.common.components

import androidx.lifecycle.LifecycleOwner

class Event<T>(private val mContent: T) {

    private val mConsumers: MutableList<LifecycleOwner> = mutableListOf()
    private var mHasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (mHasBeenHandled) {
            null
        } else {
            mHasBeenHandled = true
            mContent
        }
    }

    /**
     * Returns the content and prevents its use again. If need to consume on lifecycleOwners
     */
    fun getContentIfNotHandled(lifecycleOwner: LifecycleOwner): T? {
        return if (mConsumers.contains(lifecycleOwner)) {
            null
        } else {
            mConsumers.add(lifecycleOwner)
            mContent
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T? {
        return mContent
    }
}