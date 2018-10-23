package com.demoss.idp.data

import com.demoss.idp.data.local.localDataModule
import com.demoss.idp.data.remote.remoteDataModule

val dataModules = listOf(
    localDataModule,
    remoteDataModule
)