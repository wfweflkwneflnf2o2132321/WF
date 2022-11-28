package com.example.weatherfetcher

interface WeatherRepo {
   suspend fun getTemperature():String
}