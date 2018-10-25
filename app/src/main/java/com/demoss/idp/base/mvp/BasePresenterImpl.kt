package com.demoss.idp.base.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenterImpl<V : BaseView> : BasePresenter {

    protected var view: V? = null
    private var compositeDisposable = CompositeDisposable()

    // Override only for inner purposes
    @Suppress("UNCHECKED_CAST")
    final override fun attachView(view: BaseView) {
        this.view = view as V
        onCreateView()
    }

    final override fun detachView() {
        onDestroyView()
        view = null
        compositeDisposable.dispose()
    }

    final override fun viewShown() {
        onViewShown()
    }

    final override fun viewHidden() {
        compositeDisposable.clear()
        onViewHidden()
    }

    // Not necessary to implement this funs in child
    protected open fun onCreateView() {}

    protected open fun onViewShown() {}

    protected open fun onViewHidden() {}

    protected open fun onDestroyView() {}
}