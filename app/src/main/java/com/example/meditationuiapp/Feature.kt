package com.example.meditationuiapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    val description: String,
    @DrawableRes val iconId: Int,
    val category: String,
    val duration: String,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)