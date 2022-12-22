package com.example.weatherfetcher.feature.wind.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.temperature.ui.UiEvent
import com.example.weatherfetcher.feature.temperature.ui.ViewState
import com.example.weatherfetcher.feature.wind.domain.WindInteractor
import kotlinx.coroutines.launch


class WindViewModel(val interactor: WindInteractor) : BaseViewModel<WindViewState>() {

    override fun initialViewState(): WindViewState =
        WindViewState(
            isLoading = false,
            city = "",
            speed = "",
        )

    override fun reduce(event: Event, previousState: WindViewState): WindViewState? {
        when (event) {
            is WindUiEvent.GetCity -> {
                previousState.city = event.city
                viewModelScope.launch {
                    interactor.getWind(city = event.city).fold(
                        onError = {
                            processDataEvent(WindDataEvent.OnWindFetchFailed(error = it))

                        },
                        onSuccess = {
                            processDataEvent(WindDataEvent.OnWindFetchSucceed(speed = it.speed))

                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is WindDataEvent.OnWindFetchSucceed -> {
                return previousState.copy(isLoading = false, speed = event.speed)
            }

            else -> return null
        }
    }
}