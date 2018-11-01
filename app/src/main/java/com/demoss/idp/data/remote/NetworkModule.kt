package com.demoss.idp.data.remote

import com.demoss.idp.BuildConfig
import com.demoss.idp.Constants
import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        // Retrofit
        Retrofit.Builder().apply {
            baseUrl(Constants.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            client(get())
        }.build()
    }
    single {
        // OkHttp
        OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            connectTimeout(60, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            writeTimeout(60, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) addInterceptor(OkHttpProfilerInterceptor())
        }.build()
    }
}