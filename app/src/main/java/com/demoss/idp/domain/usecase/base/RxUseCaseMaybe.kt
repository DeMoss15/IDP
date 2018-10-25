package com.demoss.idp.domain.usecase.base

import com.demoss.idp.util.setDefaultSchedulers
import io.reactivex.Maybe
import io.reactivex.observers.DisposableMaybeObserver

abstract class RxUseCaseMaybe<T, Params> : BaseRxUseCase<T, Params, Maybe<T>, DisposableMaybeObserver<T>>() {
    final override fun execute(observer: DisposableMaybeObserver<T>, params: Params) {
        addDisposable(
            buildUseCaseObservable(params)
                .setDefaultSchedulers()
                .subscribeWith(observer)
        )
    }
}