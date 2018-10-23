package com.demoss.idp.base.mvp

interface BasePresenter {

    fun attachView(view: BaseView)
    fun detachView()
    fun viewShown()
    fun viewHidden()
}