package com.hrudhaykanth116.openplayassignment.data.datasources.remote

import com.hrudhaykanth116.openplayassignment.data.datasources.remote.retrofit.OpenWeatherApiService
import javax.inject.Inject

class WeatherForeCastRemoteDataSource @Inject constructor(
    private val openWeatherApiService: OpenWeatherApiService
): BaseNetworkDataSource() {

    suspend fun getWeatherForeCast(latitude: String, longitude: String) = getResult{
        openWeatherApiService.getDailyWeatherForeCast(latitude, longitude)
    }


}