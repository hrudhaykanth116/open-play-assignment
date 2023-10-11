package com.hrudhaykanth116.openplayassignment.ui.models.home

import com.hrudhaykanth116.openplayassignment.domain.models.UIText
import kotlinx.collections.immutable.ImmutableList

data class WeatherHomeScreenUIState(
    val location: String = "Hyderabad",
    val isInSearchMode: Boolean = false,
    val locationError: UIText? = null,
    val isLoading: Boolean = true,
    val todayWeatherUIState: TodayWeatherUIState? = null,
    val errorMessage: UIText? = null,
)

data class TodayWeatherUIState(
    val weatherMain: WeatherMain? = null,
    val weatherElementUIState: ImmutableList<WeatherElementUIState>? = null,
    val time: UIText? = null,
    val weatherHourlyList: ImmutableList<HourlyWeatherUIState>? = null,
)

data class HourlyWeatherUIState(
    val weatherMain: WeatherMain,
    val time: UIText,
)

data class DailyWeatherUIState(
    val weatherElementsList: List<WeatherElement>,
    val weatherMain: WeatherMain?,
    val time: UIText,
)
