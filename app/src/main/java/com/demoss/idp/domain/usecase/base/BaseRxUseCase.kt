package com.demoss.idp.domain.usecase.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseRxUseCase<T, Params, Source, Observer> {

    abstract fun buildUseCaseObservable(params: Params): Source

    abstract fun execute(observer: Observer, params: Params)

    private val compositeDisposable = CompositeDisposable()

    fun clear() = compositeDisposable.apply {
        if (!isDisposed)
            clear()
    }

    fun dispose() = compositeDisposable.dispose()

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)
}