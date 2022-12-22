package com.example.weatherfetcher

import android.app.Application
import com.example.weatherfetcher.feature.temperature.di.weatherScreenModule
import com.example.weatherfetcher.feature.wind.di.windScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin



class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(weatherScreenModule,windScreenModule)

        }
    }
}