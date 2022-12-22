package com.example.weatherfetcher.feature.temperature.ui


import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.temperature.domain.WeatherInteractor
import kotlinx.coroutines.launch

class TemperatureViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {


    override fun initialViewState(): ViewState =
        ViewState(
            isLoading = false,
            city = "",
            temperature = ""
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.GetCity -> {
                previousState.city = event.city
                viewModelScope.launch {
                    interactor.getWeather(city = event.city).fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))

                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(temperature = it.temperature))

                        }
                    )
                }

                return previousState.copy(isLoading = true)
            }
            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }

            else -> return null
        }
    }
}