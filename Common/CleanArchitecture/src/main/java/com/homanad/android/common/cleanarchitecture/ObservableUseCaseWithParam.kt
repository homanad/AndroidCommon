package com.homanad.android.common.cleanarchitecture

import io.reactivex.Observable
import io.reactivex.Scheduler

abstract class ObservableUseCaseWithParam<T, Param>(
    private val executorThread: Scheduler,
    private val uiThread: Scheduler
) {

    operator fun invoke(param: Param): Observable<T> {
        return create(param).subscribeOn(executorThread).observeOn(uiThread)
    }

    protected abstract fun create(param: Param): Observable<T>
}