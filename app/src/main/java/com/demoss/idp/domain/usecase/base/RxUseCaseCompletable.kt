package com.demoss.idp.domain.usecase.base

import com.demoss.idp.util.setDefaultSchedulers
import io.reactivex.Completable
import io.reactivex.observers.DisposableCompletableObserver

abstract class RxUseCaseCompletable<T, Params> : BaseRxUseCase<T, Params, Completable, DisposableCompletableObserver>() {
    final override fun execute(observer: DisposableCompletableObserver, params: Params) {
        addDisposable(
            buildUseCaseObservable(params)
                .setDefaultSchedulers()
                .subscribeWith(observer)
        )
    }
}