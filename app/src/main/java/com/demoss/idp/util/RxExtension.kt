package com.demoss.idp.util

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


// Default schedulers ==================================================================================================

fun <T> Observable<T>.setDefaultSchedulers(): Observable<T> = this.observeOn(Schedulers.io())
    .subscribeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.setDefaultSchedulers(): Single<T> = this.observeOn(Schedulers.io())
    .subscribeOn(AndroidSchedulers.mainThread())

fun Completable.setDefaultSchedulers(): Completable = this.observeOn(Schedulers.io())
    .subscribeOn(AndroidSchedulers.mainThread())

fun <T> Maybe<T>.setDefaultSchedulers(): Maybe<T> = this.observeOn(Schedulers.io())
    .subscribeOn(AndroidSchedulers.mainThread())