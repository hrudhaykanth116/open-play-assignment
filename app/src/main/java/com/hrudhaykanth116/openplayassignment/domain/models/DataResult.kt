package com.hrudhaykanth116.openplayassignment.domain.models

sealed class DataResult<out T> {
    data class Success<out T>(val data: T) : DataResult<T>()
    data class Error(
        // Use this to show as error message on UI.
        val uiMessage: UIText = "Something went wrong".toUIText(),
        // Use this to show as error description on UI.
        val uiDescription: UIText? = null,
    ) : DataResult<Nothing>()

    fun <R> process(
        onSuccess: ((T) -> R),
        onError: ((Error) -> R),
    ): R {
        return when (this) {
            is Error -> onError.invoke(this)
            is Success -> onSuccess.invoke(this.data)
        }
    }

}