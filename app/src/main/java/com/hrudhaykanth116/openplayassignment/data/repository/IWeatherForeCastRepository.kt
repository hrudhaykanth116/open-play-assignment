package com.hrudhaykanth116.openplayassignment.data.repository

import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.data.models.WeatherForeCastResponse

interface IWeatherForeCastRepository {

    suspend fun getDailyWeatherForeCast(latitude: String, longitude: String): DataResult<WeatherForeCastResponse>

}