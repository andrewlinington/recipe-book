package com.exstream.recipebook.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun DsIcon(
    icon: IconContent
) {
    Icon(
        painterResource(icon.icon),
        contentDescription = icon.contentDescription
    )
}

data class IconContent(
    @DrawableRes val icon: Int,
    val contentDescription: String
)