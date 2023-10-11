package com.hrudhaykanth116.openplayassignment.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenCallbacks
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenEvent
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenUIState

@Composable
fun WeatherHomeScreen(
    modifier: Modifier = Modifier,
    weatherHomeScreenViewModel: WeatherHomeScreenViewModel = hiltViewModel(),
) {

    val state: State<WeatherHomeScreenUIState> =
        weatherHomeScreenViewModel.stateFlow.collectAsStateWithLifecycle()

    WeatherHomeScreenUI(
        state.value,
        weatherHomeScreenCallbacks = WeatherHomeScreenCallbacks(
            onLocationTextChanged = {
                weatherHomeScreenViewModel.processEvent(WeatherHomeScreenEvent.OnLocationTextChanged(it))
            },
            search = {
                weatherHomeScreenViewModel.processEvent(WeatherHomeScreenEvent.Search)
            }
        ),
        modifier = modifier,
    )




}