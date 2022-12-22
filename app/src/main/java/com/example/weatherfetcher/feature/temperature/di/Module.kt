package com.example.weatherfetcher.feature.temperature.di

import com.example.weatherfetcher.feature.BASE_URL
import com.example.weatherfetcher.feature.temperature.data.network.WeatherRemoteSource
import com.example.weatherfetcher.feature.temperature.data.WeatherRepo
import com.example.weatherfetcher.feature.temperature.data.WeatherRepoImpl
import com.example.weatherfetcher.feature.temperature.domain.WeatherInteractor
import com.example.weatherfetcher.feature.temperature.data.network.WeatherApi
import com.example.weatherfetcher.feature.temperature.ui.TemperatureViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {


    single<OkHttpClient> {
        OkHttpClient
            .Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }
    single<WeatherApi> { get<Retrofit>().create(WeatherApi::class.java) }

    single { WeatherRemoteSource(get<WeatherApi>()) }

    single<WeatherRepo> { WeatherRepoImpl(get<WeatherRemoteSource>()) }


    single { WeatherInteractor(get<WeatherRepo>()) }

    viewModel  { TemperatureViewModel(get<WeatherInteractor>()) }
}


