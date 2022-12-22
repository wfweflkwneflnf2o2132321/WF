package com.example.weatherfetcher.feature.temperature.data

import com.example.weatherfetcher.feature.temperature.domain.WeatherModel
import com.example.weatherfetcher.feature.temperature.data.network.model.WeatherRemoteModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.main.temperature
)