package com.example.myapplication.features.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

// Created by Gbenga Oladipupo(Devmike01) on 5/16/21.

@Composable
fun StateCodelabTheme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
    colors = colors,
    typography = typography,
    shapes = shapes,
    content = content,
    )
}


private val DarkColorPalette = darkColors(
    primary = white100,
    primaryVariant = grey800,
    secondary = teal200,
    background = grey800,
)

private val LightColorPalette = lightColors(
        primary = purple500,
        primaryVariant = purple700,
        secondary = teal200
)