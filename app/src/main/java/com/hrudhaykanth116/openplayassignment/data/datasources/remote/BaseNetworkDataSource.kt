package com.hrudhaykanth116.openplayassignment.data.datasources.remote

import android.util.Log
import com.hrudhaykanth116.openplayassignment.domain.models.DataResult
import com.hrudhaykanth116.openplayassignment.domain.models.toUIText
import retrofit2.Response

abstract class BaseNetworkDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): DataResult<T> {

        // TODO: Check for internet.
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return DataResult.Success(body)
            }

            // TODO: Map appropriate error message
            val apiError: DataResult.Error = DataResult.Error(
                uiMessage = "Something went wrong".toUIText()
            )

            Log.e(TAG, "getResult: ${apiError.uiMessage}")
            return apiError
        } catch (e: Exception) {
            Log.e(TAG, "getResult: ", e)
            // TODO: Map appropriate error message
            return DataResult.Error(
                uiMessage = "Something went wrong".toUIText()
            )
        }
    }


    companion object {
        private const val TAG = "NetworkDataSource"
    }
}

