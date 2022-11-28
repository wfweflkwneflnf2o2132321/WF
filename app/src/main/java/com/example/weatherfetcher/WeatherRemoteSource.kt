package com.example.weatherfetcher

import retrofit2.Response

class WeatherRemoteSource(private val api: WeatherApi) {
    // TODO add query
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Vladivostok")

    }
}