package com.hrudhaykanth116.openplayassignment.utils.date

import java.text.SimpleDateFormat
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DateTimeUtils @Inject constructor(

) {


    fun getDateFromSecs(seconds: Int?): String? {
        seconds ?: return null

        val formatter = SimpleDateFormat("dd/MMM")
        return formatter.format(Date(seconds * 1000L))
    }

    fun getTimeFromSecs(
        seconds: Int?,
        format: String = "HH:mm:ss",
    ): String? {

        seconds ?: return null
        val formatter = SimpleDateFormat(format)
        return formatter.format(Date(seconds * 1000L))
    }

    companion object {

        const val HOURS_MIN_FORMAT = "HH:mm"
    }

}