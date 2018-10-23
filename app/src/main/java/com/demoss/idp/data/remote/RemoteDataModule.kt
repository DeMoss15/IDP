package com.demoss.idp.data.remote

import com.demoss.idp.data.remote.api.apiModule
import com.demoss.idp.data.remote.repository.remoteRepositoryModule

val remoteDataModules = listOf(
    apiModule,
    remoteRepositoryModule,
    networkModule
)