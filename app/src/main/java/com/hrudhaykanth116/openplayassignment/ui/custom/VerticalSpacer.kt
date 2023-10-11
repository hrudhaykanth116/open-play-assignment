package com.hrudhaykanth116.openplayassignment.ui.custom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.hrudhaykanth116.openplayassignment.ui.theme.resources.Dimens

@Composable
fun VerticalSpacer(height: Dp = Dimens.DEFAULT_PADDING) {
    Spacer(modifier = Modifier.height(height))
}