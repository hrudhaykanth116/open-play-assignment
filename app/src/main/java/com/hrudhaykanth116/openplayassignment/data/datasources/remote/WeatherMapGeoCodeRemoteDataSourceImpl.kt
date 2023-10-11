package com.hrudhaykanth116.openplayassignment.data.datasources.remote

import com.hrudhaykanth116.openplayassignment.data.datasources.remote.retrofit.OpenWeatherApiService
import javax.inject.Inject

class WeatherMapGeoCodeRemoteDataSourceImpl @Inject constructor(
    private val openWeatherApiService: OpenWeatherApiService,
) : IGeoCodeRemoteDataSource, BaseNetworkDataSource() {

    override suspend fun getLocationInfo(location: String) = getResult {
        openWeatherApiService.getLocationInfo(location)
    }

}