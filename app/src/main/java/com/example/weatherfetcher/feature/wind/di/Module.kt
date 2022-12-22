package com.example.weatherfetcher.feature.wind.di


import com.example.weatherfetcher.feature.BASE_URL
import com.example.weatherfetcher.feature.wind.data.WindRepo
import com.example.weatherfetcher.feature.wind.data.WindRepoImpl
import com.example.weatherfetcher.feature.wind.data.network.WindApi
import com.example.weatherfetcher.feature.wind.data.network.WindRemoteSource
import com.example.weatherfetcher.feature.wind.domain.WindInteractor
import com.example.weatherfetcher.feature.wind.ui.WindViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val windScreenModule = module {


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
    single<WindApi> { get<Retrofit>().create(WindApi::class.java) }

    single { WindRemoteSource(get<WindApi>()) }

    single<WindRepo> { WindRepoImpl(get<WindRemoteSource>()) }


    single { WindInteractor(get<WindRepo>()) }

    viewModel  { WindViewModel(get<WindInteractor>()) }
}