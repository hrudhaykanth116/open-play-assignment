package com.hrudhaykanth116.openplayassignment.ui.custom

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.hrudhaykanth116.openplayassignment.domain.models.UIText

@Composable
fun AppText(
    uiText: UIText?,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle = LocalTextStyle.current
) {

    val text1 = uiText?.getText()
    if (text1.isNullOrEmpty()) return
    Text(
        text = text1,
        modifier = modifier,
        fontSize = fontSize,
        style = style
    )
}