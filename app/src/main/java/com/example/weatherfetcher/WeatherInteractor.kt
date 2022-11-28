package com.example.weatherfetcher

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
   suspend fun getWeather(): String{
        return weatherRepo.getTemperature()
    }
}