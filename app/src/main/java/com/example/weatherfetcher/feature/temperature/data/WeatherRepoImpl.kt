package com.example.weatherfetcher.feature.temperature.data

import com.example.weatherfetcher.feature.temperature.data.network.WeatherRemoteSource
import com.example.weatherfetcher.feature.temperature.domain.WeatherModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource): WeatherRepo {

    override suspend fun getTemperature(city: String): WeatherModel {

        return weatherRemoteSource.getWeather(city = city).toDomain()
    }
}