package com.hrudhaykanth116.openplayassignment.ui.screens.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hrudhaykanth116.openplayassignment.ui.theme.resources.Dimens
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherHomeScreenCallbacks
import com.hrudhaykanth116.openplayassignment.ui.custom.AppSearchBar

@Composable
fun LocationSearchBar(
    location: String,
    weatherHomeScreenCallbacks: WeatherHomeScreenCallbacks,
    modifier: Modifier = Modifier,
) {

    AppSearchBar(
        text = location,
        modifier = modifier.padding(horizontal = Dimens.DEFAULT_PADDING),
        onTextChange = weatherHomeScreenCallbacks.onLocationTextChanged,
        onSearch = weatherHomeScreenCallbacks.search,
        content = {
            // TODO: Show suggestions if available
        }
    )

}