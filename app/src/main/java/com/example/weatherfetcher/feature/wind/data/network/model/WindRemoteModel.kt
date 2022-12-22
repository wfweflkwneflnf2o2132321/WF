package com.example.weatherfetcher.feature.wind.data.network.model

import com.google.gson.annotations.SerializedName

data class WindRemoteModel (
    @SerializedName("wind")
    val wind: WindMainRemoteModel
    )