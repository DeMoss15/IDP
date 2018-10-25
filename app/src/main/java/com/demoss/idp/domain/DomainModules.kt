package com.demoss.idp.domain

import com.demoss.idp.domain.model.modelModule
import com.demoss.idp.domain.usecase.useCaseModule
import org.koin.dsl.module.Module

val domainModules = listOf(
    useCaseModule,
    modelModule
)