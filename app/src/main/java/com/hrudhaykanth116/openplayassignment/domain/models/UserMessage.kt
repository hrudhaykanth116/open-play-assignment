package com.hrudhaykanth116.openplayassignment.domain.models

import androidx.compose.runtime.Immutable

/**
 * User message that needs to be shown may as toast, snack bar, dialog etc..
 */
@Immutable
sealed interface UserMessage{

    // Success messages may be shown in green color with success icon.
    data class Success(val message: UIText): UserMessage

    // Error messages may be shown in Red color with error icon.
    data class Error(val message: UIText): UserMessage

    // Warning messages may be shown in Orange color with warning icon.
    data class Warning(val message: UIText): UserMessage

}
