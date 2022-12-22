package com.example.weatherfetcher.feature.wind.data

import com.example.weatherfetcher.feature.wind.domain.WindModel


interface WindRepo {
    suspend fun getSpeed(city: String): WindModel
}