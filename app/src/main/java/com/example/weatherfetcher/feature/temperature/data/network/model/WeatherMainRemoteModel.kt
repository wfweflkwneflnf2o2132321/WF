package com.example.weatherfetcher.feature.temperature.data.network.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel (
    @SerializedName("temp")
    val temperature: String

)
