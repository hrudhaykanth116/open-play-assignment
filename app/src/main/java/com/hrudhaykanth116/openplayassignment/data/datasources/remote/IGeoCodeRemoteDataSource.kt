package com.hrudhaykanth116.openplayassignment.data.datasources.remote

import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.data.models.GetLocationInfoResponseItem

interface IGeoCodeRemoteDataSource {

    suspend fun getLocationInfo(location: String): DataResult<List<GetLocationInfoResponseItem>>

}