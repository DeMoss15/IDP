package com.demoss.idp.data

import com.demoss.idp.data.local.localDataModules
import com.demoss.idp.data.remote.networkModule
import com.demoss.idp.data.remote.remoteDataModules
import com.demoss.idp.data.repository.repositoryDataModule

val dataModules = localDataModules +
        remoteDataModules +
        repositoryDataModule