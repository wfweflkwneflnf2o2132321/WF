package com.example.weatherfetcher.feature.wind.ui

import com.example.weatherfetcher.base.Event

data class WindViewState(
    val isLoading: Boolean,
    var city: String,
    val speed: String,
    )

sealed class WindUiEvent : Event {
    data class GetCity(val city: String) : WindUiEvent()
}
sealed class WindDataEvent: Event {
    data class OnWindFetchSucceed(val speed: String): WindDataEvent()
    data class OnWindFetchFailed(val error: Throwable): WindDataEvent()
}