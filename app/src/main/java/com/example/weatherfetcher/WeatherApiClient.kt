package com.example.weatherfetcher

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object WeatherApiClient {
private val okHttpClient = OkHttpClient.Builder()
    .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

private val weatherApi = retrofit.create(WeatherApi::class.java)


    fun getApi(): WeatherApi {
        return weatherApi

    }
}