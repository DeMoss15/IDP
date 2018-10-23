package com.demoss.idp

import com.demoss.idp.data.dataModules
import com.demoss.idp.data.remote.networkModule
import com.demoss.idp.domain.domainModules
import com.demoss.idp.presentation.presentationModules
import org.koin.dsl.module.Module

val applicationModule: List<Module> = presentationModules +
        domainModules +
        dataModules