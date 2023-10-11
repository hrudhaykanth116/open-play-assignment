package com.hrudhaykanth116.openplayassignment.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hrudhaykanth116.openplayassignment.ui.custom.HorizontalSpacer
import com.hrudhaykanth116.openplayassignment.ui.custom.AppIcon
import com.hrudhaykanth116.openplayassignment.ui.custom.AppText
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherMain

@Composable
fun CurrentWeatherMain(
    weatherMain: WeatherMain?,
    modifier: Modifier = Modifier,
) {

    // TODO: Add some ui or ignore
    weatherMain ?: return

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AppIcon(
            imageHolder = weatherMain.icon,
            iconModifier = Modifier.size(60.dp),
            tint = Color.Unspecified
        )
        HorizontalSpacer()
        Column {
            AppText(
                uiText = weatherMain.title,
                style = MaterialTheme.typography.titleLarge,
            )
            AppText(
                uiText = weatherMain.description,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}