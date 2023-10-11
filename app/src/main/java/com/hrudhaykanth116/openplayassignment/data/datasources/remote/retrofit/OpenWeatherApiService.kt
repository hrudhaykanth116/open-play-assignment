package com.hrudhaykanth116.openplayassignment.data.datasources.remote.retrofit

import com.hrudhaykanth116.openplayassignment.confidential.ApiKeys
import com.hrudhaykanth116.openplayassignment.data.models.GetLocationInfoResponseItem
import com.hrudhaykanth116.openplayassignment.data.models.WeatherForeCastResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApiService {

    /**
     * https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
     * By default 7 days daily as per the api
     */
    @GET("data/3.0/onecall")
    suspend fun getDailyWeatherForeCast(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        // @Query("units") units: String = "metric",
        // @Query("exclude") exclude: String = "hourly,minutely",
        @Query("appid") token: String = ApiKeys.FORECAST_API_KEY,
    ): Response<WeatherForeCastResponse>

    @GET("geo/1.0/direct")
    suspend fun getLocationInfo(
        @Query("q") location: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") token: String = ApiKeys.GEO_CODING_API_KEY,
    ): Response<List<GetLocationInfoResponseItem>>

}
