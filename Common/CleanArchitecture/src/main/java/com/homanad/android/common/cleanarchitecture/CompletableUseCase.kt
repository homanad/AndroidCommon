package com.homanad.android.common.cleanarchitecture

import io.reactivex.Completable
import io.reactivex.Scheduler

abstract class CompletableUseCase(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(): Completable {
        return create().subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(): Completable
}