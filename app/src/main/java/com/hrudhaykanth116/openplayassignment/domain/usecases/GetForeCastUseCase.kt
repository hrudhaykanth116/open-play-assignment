package com.hrudhaykanth116.openplayassignment.domain.usecases

import com.hrudhaykanth116.openplayassignment.data.models.WeatherForeCastResponse
import com.hrudhaykanth116.openplayassignment.data.repository.IGeoCodeRepository
import com.hrudhaykanth116.openplayassignment.data.repository.IWeatherForeCastRepository
import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.domain.models.UIText
import com.hrudhaykanth116.openplayassignment.ui.models.home.TodayWeatherUIState
import javax.inject.Inject

class GetForeCastUseCase @Inject constructor(
    private val geoCodeRepository: IGeoCodeRepository,
    private val weatherForeCastRepository: IWeatherForeCastRepository,
    private val parseCurrentWeatherUseCase: ParseCurrentWeatherUseCase,
) {

    suspend operator fun invoke(
        location: String,
    ): DataResult<TodayWeatherUIState> {

        when (val locationInfoDataResult = geoCodeRepository.getLocationInfo(location)) {
            is DataResult.Error -> {
                return DataResult.Error(UIText.Text("No information found on entered Location"))
            }

            is DataResult.Success -> {

                val locationInfo =
                    locationInfoDataResult.data.firstOrNull()
                        ?: return DataResult.Error(UIText.Text("No information found on entered Location"))

                return when (
                    val foreCastResult: DataResult<WeatherForeCastResponse> =
                        weatherForeCastRepository.getDailyWeatherForeCast(
                            locationInfo.lat?.toString().orEmpty(),
                            locationInfo.lon?.toString().orEmpty(),
                        )
                ) {
                    is DataResult.Error -> {
                        DataResult.Error(foreCastResult.uiMessage)
                    }

                    is DataResult.Success -> {
                        val currentWeatherUIState =
                            parseCurrentWeatherUseCase(foreCastResult.data)
                        DataResult.Success(currentWeatherUIState)
                    }
                }
            }
        }
    }
}