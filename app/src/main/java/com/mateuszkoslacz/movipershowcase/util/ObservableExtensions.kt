package com.mateuszkoslacz.movipershowcase.util

import io.reactivex.Observable

fun <T> Observable<T>.retrySubscribe(onNext: (T) -> Unit,
                                     onError: (Throwable) -> Unit) =
        this.doOnNext(onNext)
                .doOnError(onError)
                .retry()
                .subscribe()!!

