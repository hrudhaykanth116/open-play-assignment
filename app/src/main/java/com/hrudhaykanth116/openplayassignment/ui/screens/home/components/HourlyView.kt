package com.hrudhaykanth116.openplayassignment.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrudhaykanth116.openplayassignment.ui.theme.resources.Dimens
import com.hrudhaykanth116.openplayassignment.R
import com.hrudhaykanth116.openplayassignment.domain.models.toImageHolder
import com.hrudhaykanth116.openplayassignment.domain.models.toUIText
import com.hrudhaykanth116.openplayassignment.ui.custom.AppIcon
import com.hrudhaykanth116.openplayassignment.ui.custom.AppText
import com.hrudhaykanth116.openplayassignment.ui.custom.CenteredColumn
import com.hrudhaykanth116.openplayassignment.ui.models.home.HourlyWeatherUIState
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherMain

@Composable
fun HourlyView(
    state: List<HourlyWeatherUIState>?,
    modifier: Modifier = Modifier,
) {

    state ?: return
    HourlyViewRow(
        state
    )

}

@Composable
private fun HourlyViewRow(
    state: List<HourlyWeatherUIState>,
    modifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Dimens.DEFAULT_PADDING),
        contentPadding = PaddingValues(Dimens.DEFAULT_PADDING),
    ) {
        items(state) { hourlyWeatherUIState ->

            val weatherMain: WeatherMain = hourlyWeatherUIState.weatherMain

            CenteredColumn(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(25))
                    .background(
                        color = MaterialTheme.colorScheme.surface
                    )
                    .padding(Dimens.DEFAULT_PADDING)
            ) {
                AppIcon(
                    imageHolder = weatherMain.icon,
                    uiText = hourlyWeatherUIState.time,
                    isTextFirst = true,
                    modifier = Modifier,
                    iconModifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )
                AppText(
                    uiText = weatherMain.title,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}

@Preview
@Composable
fun HourlyViewPreview() {
    HourlyView(
        state = listOf(
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
            HourlyWeatherUIState(
                weatherMain = WeatherMain(
                    "Cloudy".toUIText(),
                    "Rainy".toUIText(),
                    R.drawable.ic_clouds.toImageHolder()
                ), time = "22 09".toUIText()
            ),
        ),
        modifier = Modifier
    )
}