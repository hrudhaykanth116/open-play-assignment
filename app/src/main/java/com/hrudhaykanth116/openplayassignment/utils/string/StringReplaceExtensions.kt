package com.hrudhaykanth116.openplayassignment.utils.string

/**
 * Replaces the string with given value if the string is null or blank
 */
fun String?.replaceIfBlank(value: String): String {
    return if (isNullOrEmpty()) {
        value
    } else
        this
}