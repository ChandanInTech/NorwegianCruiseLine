package com.chandan.norwegiancruiseline.dependency_injection

import com.chandan.norwegiancruiseline.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsModule = module {
    viewModel {
        DetailsViewModel(get())
    }
}
