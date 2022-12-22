package com.example.weatherfetcher.feature.wind.data.network

import com.example.weatherfetcher.feature.API_KEY
import com.example.weatherfetcher.feature.wind.data.network.model.WindRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WindApi {
    @GET("weather")
    suspend fun getWind(
        @Query("q") query: String,
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): WindRemoteModel
}