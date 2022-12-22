package com.example.weatherfetcher.feature.wind.data.network

import com.example.weatherfetcher.feature.wind.data.network.model.WindRemoteModel

class WindRemoteSource (private val api: WindApi) {
    suspend fun getWind(city: String): WindRemoteModel {
        return api.getWind(query = city)
    }

}