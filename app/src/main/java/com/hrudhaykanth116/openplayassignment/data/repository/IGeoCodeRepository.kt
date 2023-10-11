package com.hrudhaykanth116.openplayassignment.data.repository

import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.data.models.GetLocationInfoResponseItem

interface IGeoCodeRepository{

    suspend fun getLocationInfo(location: String): DataResult<List<GetLocationInfoResponseItem>>

}