package com.demoss.idp.data.local

import com.demoss.idp.data.local.repository.localRepositoryModule

val localDataModules = listOf(
    dbModule,
    localRepositoryModule
)