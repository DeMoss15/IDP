package com.demoss.idp.base.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<in V : BaseView> : BasePresenter {

    private var view: V? = null
    private var compositeDisposable = CompositeDisposable()

    override fun attachView(view: BaseView) {
        this.view = view as V
        onCreateView()
    }

    override fun detachView() {
        onDestroyView()
        view = null
        compositeDisposable.dispose()
    }

    override fun viewShown() {
        onViewShown()
    }

    override fun viewHidden() {
        compositeDisposable.clear()
        onViewHidden()
    }

    open fun onCreateView() {}

    open fun onViewShown() {}

    open fun onViewHidden() {}

    open fun onDestroyView() {}
}