package com.hrudhaykanth116.openplayassignment.ui.models.home

import com.hrudhaykanth116.openplayassignment.domain.models.ImageHolder
import com.hrudhaykanth116.openplayassignment.domain.models.UIText

data class WeatherMain(
    val title: UIText,
    val description: UIText,
    val icon: ImageHolder,
)