package com.hrudhaykanth116.openplayassignment.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.hrudhaykanth116.openplayassignment.R
import com.hrudhaykanth116.openplayassignment.data.repository.UserPrefsRepository
import com.hrudhaykanth116.openplayassignment.domain.models.UIText
import com.hrudhaykanth116.openplayassignment.domain.models.toUIText
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenEffect
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenEvent
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenUIState
import com.hrudhaykanth116.openplayassignment.domain.usecases.GetForeCastUseCase
import com.hrudhaykanth116.openplayassignment.ui.screens.UDFViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherHomeScreenViewModel @Inject constructor(
    private val getForeCastUseCase: GetForeCastUseCase,
    private val userPrefsRepository: UserPrefsRepository,
) : UDFViewModel<WeatherHomeScreenUIState, WeatherHomeScreenEvent, WeatherHomeScreenEffect>(
    WeatherHomeScreenUIState()
) {

    private var fetchWeatherJob: Job? = null

    init {

        setState {
            copy(
                location = userPrefsRepository.getLastUsedLocation()
            )
        }

        fetchData()
    }

    private fun fetchData() {
        fetchWeatherJob?.cancel()

        val location = state.location
        if (location.isBlank()) {
            setState {
                copy(
                    errorMessage = UIText.StringRes(R.string.please_enter_location_name),
                    isLoading = false,
                )
            }
            return
        }

        fetchWeatherJob = viewModelScope.launch {

            setState {
                copy(
                    isLoading = true
                )
            }

            val foreCastDataResult = getForeCastUseCase(
                location,
            )

            foreCastDataResult.process(
                onSuccess = {

                    setState {
                        copy(
                            todayWeatherUIState = it,
                            isLoading = false,
                            errorMessage = null,
                        )
                    }

                    saveLocation(state.location)
                },
                onError = {
                    setState {
                        copy(
                            errorMessage = R.string.something_went_wrong.toUIText(),
                            isLoading = false,
                        )
                    }
                }
            )
        }

    }

    private fun saveLocation(location: String) {
        userPrefsRepository.saveLastUsedLocation(location)
    }

    override fun processEvent(event: WeatherHomeScreenEvent) {
        when (event) {
            is WeatherHomeScreenEvent.Refresh -> {
                fetchData()
            }

            is WeatherHomeScreenEvent.UserMessageShown -> setState {
                copy(
                    errorMessage = null
                )
            }

            is WeatherHomeScreenEvent.OnLocationTextChanged -> setState {
                copy(
                    location = event.newLocationText
                )
            }

            WeatherHomeScreenEvent.Search -> fetchData()
        }
    }

}