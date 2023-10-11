package com.hrudhaykanth116.openplayassignment.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.ImageBitmap

/**
 * A wrapper around any type of images that needs to be rendered on UI.
 * Useful for abstraction on the type of image to display.
 */
sealed class ImageHolder(val data: Any?){
    data class LocalDrawableResource(@DrawableRes val resId: Int): ImageHolder(resId)
    data class Url(val url: String?): ImageHolder(url)
}

fun Int.toImageHolder(): ImageHolder.LocalDrawableResource {
    return ImageHolder.LocalDrawableResource(this)
}

fun String.toUrlImageHolder() = ImageHolder.Url(this)