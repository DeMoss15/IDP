package com.demoss.idp.data.remote.api

import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {

    single { getApi(get()) } // API
}

private fun getApi(retrofit: Retrofit){}//: [YourApi] = retrofit.create([YourApi]::class.java)