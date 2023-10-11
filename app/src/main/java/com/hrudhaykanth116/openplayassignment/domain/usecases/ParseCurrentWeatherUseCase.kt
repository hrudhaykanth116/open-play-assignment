package com.hrudhaykanth116.openplayassignment.domain.usecases

import com.hrudhaykanth116.openplayassignment.utils.conversions.TemperatureConverter
import com.hrudhaykanth116.openplayassignment.data.models.WeatherForeCastResponse
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherElement
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherElementUIState
import com.hrudhaykanth116.openplayassignment.ui.models.home.HourlyWeatherUIState
import com.hrudhaykanth116.openplayassignment.ui.models.home.TodayWeatherUIState
import com.hrudhaykanth116.openplayassignment.ui.models.home.WeatherMain
import com.hrudhaykanth116.openplayassignment.domain.models.toUIText
import com.hrudhaykanth116.openplayassignment.domain.models.toUrlImageHolder
import com.hrudhaykanth116.openplayassignment.utils.date.DateTimeUtils
import com.hrudhaykanth116.openplayassignment.utils.number.truncateToDecimals
import com.hrudhaykanth116.openplayassignment.utils.string.replaceIfBlank
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ParseCurrentWeatherUseCase @Inject constructor(
    private val dateTimeUtils: DateTimeUtils,
    private val temperatureConverter: TemperatureConverter,
    private val getWeatherIconUseCase: GetWeatherIconUseCase,
) {

    suspend operator fun invoke(
        weatherForeCastDTO: WeatherForeCastResponse,
    ): TodayWeatherUIState {

        val current = weatherForeCastDTO.current

        val currentWeather = current?.weather?.firstOrNull()

        val humidity = current?.humidity.toUIText("- -")
        val sunrise = dateTimeUtils.getTimeFromSecs(current?.sunrise).toUIText("- -")
        val sunset = dateTimeUtils.getTimeFromSecs(current?.sunset).toUIText("- -")
        val windSpeed = current?.windSpeed.toUIText("- -")
        val clouds = current?.clouds.toUIText("- -")
        val pressure = current?.pressure.toUIText("- -")
        val temp = temperatureConverter.getCelsiusFromKelvin(current?.temp)
            ?.truncateToDecimals(1).toUIText("- -")
        val dewPoint = current?.dewPoint.toUIText("- -")
        val dt = dateTimeUtils.getDateFromSecs(current?.dt).orEmpty().toUIText()
        val feelsLike = current?.feelsLike.toUIText("- -")
        val uvi = current?.uvi.toUIText("- -")
        val visibility = current?.visibility.toUIText("- -")
        val windDeg = current?.windDeg.toUIText("- -")

        return TodayWeatherUIState(
            // Temperature in Kelvin
            // Wind speed in meter/sec
            // Pressure hPa
            // Clouds %
            // rain mm/h
            // HUmidity %
            // Assuming non null values.
            time = dt,
            weatherMain = WeatherMain(
                title = currentWeather?.main.replaceIfBlank("- -").toUIText(),
                description = currentWeather?.description.replaceIfBlank("- -").toUIText(),
                icon = getWeatherIconUseCase(currentWeather?.icon).toUrlImageHolder(),
            ),
            weatherElementUIState = persistentListOf<WeatherElementUIState>(
                WeatherElementUIState(WeatherElement.TEMP, temp),
                WeatherElementUIState(WeatherElement.FEELS_LIKE, feelsLike),
                WeatherElementUIState(WeatherElement.HUMIDITY, humidity),
                WeatherElementUIState(WeatherElement.DEW_POINT, dewPoint),
                WeatherElementUIState(WeatherElement.CLOUDS, clouds),
                WeatherElementUIState(WeatherElement.SUNRISE, sunrise),
                WeatherElementUIState(WeatherElement.SUNSET, sunset),
                WeatherElementUIState(WeatherElement.PRESSURE, pressure),
                WeatherElementUIState(WeatherElement.UVI, uvi),
                WeatherElementUIState(WeatherElement.VISIBILITY, visibility),
                WeatherElementUIState(WeatherElement.WIND_DEG, windDeg),
                WeatherElementUIState(WeatherElement.WIND_SPEED, windSpeed),
            ),
            weatherHourlyList = getHourlyWeatherUIState(weatherForeCastDTO.hourly)
        )

    }

    private fun getHourlyWeatherUIState(
        hourlyWeatherList: List<WeatherForeCastResponse.Hourly?>?,
    ): ImmutableList<HourlyWeatherUIState> {
        val hourlyWeatherUIStateList = mutableListOf<HourlyWeatherUIState>()

        hourlyWeatherList?.forEach { hourlyWeather: WeatherForeCastResponse.Hourly? ->

            hourlyWeather?.let { hourly: WeatherForeCastResponse.Hourly ->
                val weatherMain = hourly.weather?.firstOrNull() ?: return@forEach

                val icon = getWeatherIconUseCase(weatherMain.icon).toUrlImageHolder()

                val hourlyWeatherUIState = HourlyWeatherUIState(
                    weatherMain = WeatherMain(
                        description = weatherMain.description.replaceIfBlank("- -").toUIText(),
                        icon = icon,
                        title = weatherMain.main.replaceIfBlank("- -").toUIText()
                    ),
                    time = dateTimeUtils.getTimeFromSecs(
                        hourly.dt,
                        DateTimeUtils.HOURS_MIN_FORMAT
                    ).replaceIfBlank("- -").toUIText()
                )

                hourlyWeatherUIStateList.add(hourlyWeatherUIState)
            }

        }
        return hourlyWeatherUIStateList.toPersistentList()

    }

}