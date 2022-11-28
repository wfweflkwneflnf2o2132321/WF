package com.example.weatherfetcher

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    val main:WeatherMainRemoteModel
)
