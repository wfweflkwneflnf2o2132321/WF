package com.example.weatherfetcher

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource):WeatherRepo {
    override fun getTemperature(): String {
        return weatherRemoteSource.getWeather().message()
    }
}