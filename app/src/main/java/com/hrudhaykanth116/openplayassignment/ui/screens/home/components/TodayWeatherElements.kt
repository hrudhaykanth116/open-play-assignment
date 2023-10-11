package com.hrudhaykanth116.openplayassignment.ui.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hrudhaykanth116.openplayassignment.ui.theme.resources.Dimens
import com.hrudhaykanth116.openplayassignment.ui.custom.AppIcon
import com.hrudhaykanth116.openplayassignment.ui.custom.AppText
import com.hrudhaykanth116.openplayassignment.utils.compose.modifier.largeRadialBackground
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherMain
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherElementUIState


@Composable
fun TodayWeatherElements(
    state: List<WeatherElementUIState>?,
    weatherMain: WeatherMain?,
    modifier: Modifier = Modifier,
) {

    if (state == null || weatherMain == null) return

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp,
            pressedElevation = 2.dp,
            focusedElevation = 4.dp
        ),
        shape = RoundedCornerShape(percent = 5),
    ){

        // TODO: Static Grid may be enough
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .largeRadialBackground(
                    listOf(
                        Color(0xFF04253A),
                        Color(0xFF021D2C)
                    )
                )
            ,
            contentPadding = PaddingValues(Dimens.DEFAULT_PADDING),
            verticalArrangement = Arrangement.spacedBy(Dimens.DEFAULT_PADDING),
            horizontalArrangement = Arrangement.spacedBy(Dimens.DEFAULT_PADDING)
        ) {

            item(span = { GridItemSpan(this.maxLineSpan) }) {
                CurrentWeatherMain(
                    weatherMain,
                    modifier = Modifier
                        .fillMaxWidth()
                    // .padding(bottom = Dimens.DEFAULT_PADDING),
                )
            }

            items(state) {
                Column(
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(25))
                        .background(
                            // color = MaterialTheme.colorScheme.surface
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.White.copy(alpha = 0.2f),
                                    Color.White.copy(alpha = 0.1f)
                                ),
                            )
                        )
                        .padding(Dimens.DEFAULT_PADDING),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AppIcon(
                        imageHolder = it.weatherElement.displayIcon,
                        uiText = it.weatherElement.displayName,
                        isTextFirst = true,
                        modifier = Modifier,
                        iconModifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                    AppText(uiText = it.value, style = MaterialTheme.typography.bodyMedium)
                }
            }

        }

    }


}