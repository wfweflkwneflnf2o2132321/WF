package com.example.weatherfetcher.feature.temperature.domain

import com.example.weatherfetcher.base.attempt
import com.example.weatherfetcher.feature.temperature.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

   suspend fun getWeather(city: String) = attempt { weatherRepo.getTemperature(city = city)}
    }
