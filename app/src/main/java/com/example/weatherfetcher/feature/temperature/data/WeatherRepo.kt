package com.example.weatherfetcher.feature.temperature.data

import com.example.weatherfetcher.feature.temperature.domain.WeatherModel

interface WeatherRepo {
   suspend fun getTemperature(city: String): WeatherModel
}