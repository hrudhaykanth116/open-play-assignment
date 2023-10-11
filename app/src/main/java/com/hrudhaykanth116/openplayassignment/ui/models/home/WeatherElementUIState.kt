package com.hrudhaykanth116.openplayassignment.ui.models.home

import com.hrudhaykanth116.openplayassignment.R
import com.hrudhaykanth116.openplayassignment.domain.models.ImageHolder
import com.hrudhaykanth116.openplayassignment.domain.models.UIText
import com.hrudhaykanth116.openplayassignment.domain.models.toImageHolder

data class WeatherElementUIState(
    val weatherElement: WeatherElement,
    val value: UIText,
)

enum class WeatherElement(val id: String, val displayName: UIText, val displayIcon: ImageHolder) {

    DEW_POINT("dewPoint", UIText.Text("Dew point"), R.drawable.ic_element_dew.toImageHolder()),
    FEELS_LIKE("feelsLike", UIText.Text("Feels like"), R.drawable.ic_element_feels_lik.toImageHolder()),
    HUMIDITY("humidity", UIText.Text("Humidity"), R.drawable.ic_element_himidity.toImageHolder()),
    PRESSURE("pressure", UIText.Text("Pressure"), R.drawable.ic_element_pressure.toImageHolder()),
    CLOUDS("Clouds", UIText.Text("Clouds"), R.drawable.ic_element_clouds.toImageHolder()),
    SUNRISE("sunrise", UIText.Text("Sunrise"), R.drawable.ic_element_sunrise.toImageHolder()),
    SUNSET("sunset", UIText.Text("Sunset"), R.drawable.ic_element_sunset.toImageHolder()),
    TEMP("temp", UIText.Text("Temp"), R.drawable.ic_element_temperature.toImageHolder()),
    UVI("uvi", UIText.Text("UVI"), R.drawable.ic_element_uvi.toImageHolder()),
    VISIBILITY("visibility", UIText.Text("Visibility"), R.drawable.ic_element_visibility.toImageHolder()),
    WIND_DEG("windDeg", UIText.Text("Wind deg"), R.drawable.ic_element_wind_deg.toImageHolder()),
    WIND_SPEED("windSpeed", UIText.Text("Wind speed"), R.drawable.ic_element_wind_speed.toImageHolder()),

}