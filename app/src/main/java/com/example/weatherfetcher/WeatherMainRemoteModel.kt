package com.example.weatherfetcher

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel (
    @SerializedName("temp")
    val temperature: String

)
