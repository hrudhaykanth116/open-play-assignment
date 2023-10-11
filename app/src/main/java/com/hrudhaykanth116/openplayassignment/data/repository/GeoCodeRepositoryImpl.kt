package com.hrudhaykanth116.openplayassignment.data.repository

import com.hrudhaykanth116.openplayassignment.data.datasources.remote.IGeoCodeRemoteDataSource
import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.data.models.GetLocationInfoResponseItem
import com.hrudhaykanth116.openplayassignment.data.repository.IGeoCodeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GeoCodeRepositoryImpl @Inject constructor(
    private val geoCodeRemoteDataSource: IGeoCodeRemoteDataSource
): IGeoCodeRepository {

    private val dispatcher = Dispatchers.IO

    override suspend fun getLocationInfo(location: String): DataResult<List<GetLocationInfoResponseItem>> = withContext(dispatcher) {
        return@withContext geoCodeRemoteDataSource.getLocationInfo(location)
    }

}