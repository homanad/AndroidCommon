package com.homanad.android.common.cleanarchitecture

import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class ObservableUseCase<T>(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(): Observable<T> {
        return create().subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(): Observable<T>
}