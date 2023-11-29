package com.waffle.moviecomposeapp.module

import com.waffle.moviecomposeapp.ui.MovieViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { MovieViewModel(get()) }
}