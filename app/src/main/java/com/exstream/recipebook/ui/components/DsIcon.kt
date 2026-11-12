package com.exstream.recipebook.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DsIcon(
    icon: IconContent,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current,
    iconSize: IconSize.() -> Dp = { medium }
) {
    Icon(
        painterResource(icon.icon),
        contentDescription = icon.contentDescription,
        modifier = modifier.size(IconSize.iconSize()),
        tint = tint
    )
}

object IconSize {
    val small: Dp = 12.dp
    val medium: Dp = 16.dp
    val large: Dp = 20.dp
}

data class IconContent(
    @DrawableRes val icon: Int,
    val contentDescription: String
)