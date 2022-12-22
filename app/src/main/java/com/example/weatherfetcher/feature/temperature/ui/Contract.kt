package com.example.weatherfetcher.feature.temperature.ui

import com.example.weatherfetcher.base.Event

data class ViewState(
    val isLoading: Boolean,
    var city: String,
    val temperature: String

)

sealed class UiEvent : Event {
    data class GetCity(val city: String) : UiEvent()
}
sealed class DataEvent: Event {
    data class OnWeatherFetchSucceed(val temperature: String): DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable): DataEvent()
}