package com.hrudhaykanth116.openplayassignment.data.datasources.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesLocalDataSource @Inject constructor(
    private val userPreferences: UserPreferences,
) {

    fun saveLastUsedLocation(location: String){
        userPreferences.lastUsedLocation = location
    }

    fun getLastUsedLocation() = userPreferences.lastUsedLocation

}