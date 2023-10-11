package com.hrudhaykanth116.openplayassignment.data.di

import com.hrudhaykanth116.openplayassignment.data.datasources.remote.retrofit.OpenWeatherApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkDiModule {

    @Named("moshi")
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Named("baseurl")
    @Provides
    fun provideBaseUrl() = "https://api.openweathermap.org/"

    @Named("okhttp")
    @Singleton
    @Provides
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .build()


    @Named("retrofit")
    @Singleton
    @Provides
    fun provideRetrofit(
        @Named("okhttp") okHttpClient: OkHttpClient,
        @Named("baseurl") baseUrl: String,
        @Named("moshi") moshi: Moshi,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideForeCastApiService(@Named("retrofit") retrofit: Retrofit): OpenWeatherApiService =
        retrofit.create(OpenWeatherApiService::class.java)

}