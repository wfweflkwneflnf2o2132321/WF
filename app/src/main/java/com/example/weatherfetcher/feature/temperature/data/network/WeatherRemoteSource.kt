package com.example.weatherfetcher.feature.temperature.data.network

import com.example.weatherfetcher.feature.temperature.data.network.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {

    suspend fun getWeather(city: String): WeatherRemoteModel {
        return api.getWeather(query = city)
    }
}