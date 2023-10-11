package com.hrudhaykanth116.openplayassignment.data.repository

import com.hrudhaykanth116.openplayassignment.data.di.IoDispatcher
import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.data.datasources.remote.WeatherForeCastRemoteDataSource
import com.hrudhaykanth116.openplayassignment.data.models.WeatherForeCastResponse
import com.hrudhaykanth116.openplayassignment.data.repository.IWeatherForeCastRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherForeCastRepositoryImpl @Inject constructor(
    // TODO: Implement abstraction depending on the use case
    private val weatherForeCastRemoteDataSource: WeatherForeCastRemoteDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : IWeatherForeCastRepository {


    override suspend fun getDailyWeatherForeCast(
        latitude: String, longitude: String,
    ): DataResult<WeatherForeCastResponse> = withContext(dispatcher) {
        weatherForeCastRemoteDataSource.getWeatherForeCast(latitude, longitude)
    }


}