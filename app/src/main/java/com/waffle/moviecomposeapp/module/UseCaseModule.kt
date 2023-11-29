package com.waffle.moviecomposeapp.module

import com.waffle.moviecomposeapp.domain.usecase.PopularUseCase
import org.koin.dsl.module

val useCaseModule = module {
   factory { PopularUseCase(get()) }
}