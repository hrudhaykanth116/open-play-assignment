package com.hrudhaykanth116.openplayassignment.domain.usecases

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetWeatherIconUseCase @Inject constructor(
) {

    operator fun invoke(id: String?): String{
        // TODO: Move to constants.
        return "https://openweathermap.org/img/wn/$id@2x.png"
    }

}