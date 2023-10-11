package com.hrudhaykanth116.openplayassignment.ui.models.home

import com.hrudhaykanth116.openplayassignment.domain.models.UIText


sealed interface WeatherHomeScreenEvent{
    object Refresh: WeatherHomeScreenEvent
    object Search: WeatherHomeScreenEvent
    data class OnLocationTextChanged(val newLocationText: String): WeatherHomeScreenEvent
    data class UserMessageShown(val message: UIText): WeatherHomeScreenEvent
}