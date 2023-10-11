package com.hrudhaykanth116.openplayassignment.data.di

import com.hrudhaykanth116.openplayassignment.data.datasources.remote.IGeoCodeRemoteDataSource
import com.hrudhaykanth116.openplayassignment.data.datasources.remote.retrofit.OpenWeatherApiService
import com.hrudhaykanth116.openplayassignment.data.datasources.remote.WeatherForeCastRemoteDataSource
import com.hrudhaykanth116.openplayassignment.data.datasources.remote.WeatherMapGeoCodeRemoteDataSourceImpl
import com.hrudhaykanth116.openplayassignment.data.repository.GeoCodeRepositoryImpl
import com.hrudhaykanth116.openplayassignment.data.repository.IGeoCodeRepository
import com.hrudhaykanth116.openplayassignment.data.repository.IWeatherForeCastRepository
import com.hrudhaykanth116.openplayassignment.data.repository.WeatherForeCastRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    fun provideForeCastRepository(
        remoteDataSource: WeatherForeCastRemoteDataSource,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): IWeatherForeCastRepository = WeatherForeCastRepositoryImpl(
        remoteDataSource,
        ioDispatcher
    )

    @Provides
    fun provideGeoCodingRemoteDataSource(
        openWeatherApiService: OpenWeatherApiService,
    ): IGeoCodeRemoteDataSource = WeatherMapGeoCodeRemoteDataSourceImpl(
        openWeatherApiService
    )

    @Provides
    fun provideGeoCodingRepository(
        geoCodeRemoteDataSource: IGeoCodeRemoteDataSource,
    ): IGeoCodeRepository = GeoCodeRepositoryImpl(
        geoCodeRemoteDataSource
    )

}