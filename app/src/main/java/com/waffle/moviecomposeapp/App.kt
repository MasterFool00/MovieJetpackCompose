package com.waffle.moviecomposeapp

import android.app.Application
import com.waffle.moviecomposeapp.module.networkModule
import com.waffle.moviecomposeapp.module.repositoryModule
import com.waffle.moviecomposeapp.module.roomModule
import com.waffle.moviecomposeapp.module.useCaseModule
import com.waffle.moviecomposeapp.module.viewModelModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@App)
            modules(listOf(networkModule, viewModelModule, repositoryModule, roomModule, useCaseModule))
        }
    }
}