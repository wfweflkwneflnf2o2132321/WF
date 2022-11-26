package com.example.weatherfetcher

class WeatherInteractor(private val weatherRepo: WeatherRepo) {
    fun getWeather(): String{
        return weatherRepo.getTemperature()
    }
}