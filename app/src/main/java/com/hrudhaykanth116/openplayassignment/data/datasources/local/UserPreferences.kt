package com.hrudhaykanth116.openplayassignment.data.datasources.local

import com.chibatching.kotpref.KotprefModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferences @Inject constructor(): KotprefModel() {

    var lastUsedLocation by stringPref()

}