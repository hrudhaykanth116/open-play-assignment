package com.hrudhaykanth116.openplayassignment.utils.number

fun Float?.truncateToDecimals(digitsAfterDecimalPoint: Int): String? {
    return when {
        this == null -> {
            null
        }
        this == 0.0f -> {
            "0"
        }
        else -> {
            String.format("%.${digitsAfterDecimalPoint}f", this)
        }
    }
}

