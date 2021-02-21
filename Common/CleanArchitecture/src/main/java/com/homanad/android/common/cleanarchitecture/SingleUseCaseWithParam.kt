package com.homanad.android.common.cleanarchitecture

import io.reactivex.Scheduler
import io.reactivex.Single

abstract class SingleUseCaseWithParam<T, Param>(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(param: Param): Single<T> {
        return create(param).subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(param: Param): Single<T>
}