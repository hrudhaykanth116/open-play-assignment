package com.hrudhaykanth116.openplayassignment.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hrudhaykanth116.openplayassignment.ui.custom.AppText
import com.hrudhaykanth116.openplayassignment.ui.custom.VerticalSpacer
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenCallbacks
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenUIState
import com.hrudhaykanth116.openplayassignment.ui.screens.home.components.HourlyView
import com.hrudhaykanth116.openplayassignment.ui.screens.home.components.LocationSearchBar
import com.hrudhaykanth116.openplayassignment.ui.screens.home.components.TodayWeatherElements

@Composable
fun WeatherHomeScreenUI(
    uiState: WeatherHomeScreenUIState,
    modifier: Modifier = Modifier,
    weatherHomeScreenCallbacks: WeatherHomeScreenCallbacks = WeatherHomeScreenCallbacks(),
) {

    Scaffold(
        modifier = modifier,
        containerColor = Color.Transparent,
        topBar = {
            LocationSearchBar(
                uiState.location,
                weatherHomeScreenCallbacks,
            )
        },
    ) {
        ContentContainer(
            uiState,
            modifier = Modifier.padding(it),
        )
    }

}

@Composable
private fun ContentContainer(
    state: WeatherHomeScreenUIState,
    modifier: Modifier = Modifier,
) {


    Box(modifier = modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }else if(state.errorMessage != null){
            // TODO: Consider showing toast msg or a more illustrative image and error message
            AppText(
                uiText = state.errorMessage,
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            val weather = state.todayWeatherUIState ?: return
            Column(
                modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VerticalSpacer()
                TodayWeatherElements(
                    state.todayWeatherUIState.weatherElementUIState,
                    weather.weatherMain,
                    modifier = Modifier.fillMaxWidth()
                )
                VerticalSpacer()
                HourlyView(
                    state.todayWeatherUIState.weatherHourlyList,
                    modifier = Modifier.fillMaxWidth()
                )

            }
        }
    }

}