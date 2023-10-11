package com.hrudhaykanth116.openplayassignment.ui.models.home

data class WeatherHomeScreenCallbacks(
    val onLocationTextChanged: (String) -> Unit = {},
    val search: () -> Unit = {},
)
