package com.hrudhaykanth116.openplayassignment.data.repository

import com.hrudhaykanth116.openplayassignment.data.datasources.local.UserPreferencesLocalDataSource
import javax.inject.Inject

class UserPrefsRepository @Inject constructor(
    private val userPreferencesLocalDataSource: UserPreferencesLocalDataSource
) {

    fun saveLastUsedLocation(location: String) {
        userPreferencesLocalDataSource.saveLastUsedLocation(location)
    }

    fun getLastUsedLocation() = userPreferencesLocalDataSource.getLastUsedLocation()


}