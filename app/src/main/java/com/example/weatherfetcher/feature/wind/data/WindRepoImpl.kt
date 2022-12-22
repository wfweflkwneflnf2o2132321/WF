package com.example.weatherfetcher.feature.wind.data

import com.example.weatherfetcher.feature.temperature.data.toDomain
import com.example.weatherfetcher.feature.wind.data.network.WindRemoteSource
import com.example.weatherfetcher.feature.wind.domain.WindModel


class WindRepoImpl (private val windRemoteSource: WindRemoteSource): WindRepo {
    override suspend fun getSpeed(city: String): WindModel {

        return windRemoteSource.getWind(city = city).toDomain()
    }
}