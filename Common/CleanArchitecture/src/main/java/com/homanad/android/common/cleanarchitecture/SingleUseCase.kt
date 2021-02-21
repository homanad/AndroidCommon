package com.homanad.android.common.cleanarchitecture

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCase<T>(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(): Single<T> {
        return create().subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(): Single<T>
}