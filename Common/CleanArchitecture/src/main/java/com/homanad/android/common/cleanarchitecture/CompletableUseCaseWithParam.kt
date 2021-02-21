package com.homanad.android.common.cleanarchitecture

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCaseWithParam<Param>(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(param: Param): Completable {
        return create(param).subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(param: Param): Completable
}