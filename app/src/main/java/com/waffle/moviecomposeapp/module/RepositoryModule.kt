package com.waffle.moviecomposeapp.module

import com.waffle.moviecomposeapp.data.AppRepository
import com.waffle.moviecomposeapp.data.local.LocalDataSource
import com.waffle.moviecomposeapp.data.remote.RemoteDataSource
import com.waffle.moviecomposeapp.domain.repository.PopularRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PopularRepository> {
        AppRepository(get(), get())
    }
    single { RemoteDataSource(get()) }
    single { LocalDataSource(get()) }
}