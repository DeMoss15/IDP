package com.demoss.idp.domain

import com.demoss.idp.domain.model.modelModule
import com.demoss.idp.domain.usecase.useCaseModule

val domainModules = listOf(
    useCaseModule,
    modelModule
)