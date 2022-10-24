package com.chandan.norwegiancruiseline.dependency_injection.KoinModules

import com.chandan.norwegiancruiseline.dependency_injection.detailsModule
import org.koin.dsl.module

val nclModules = module {
    includes(
        networkModule,
        detailsModule
    )
}
