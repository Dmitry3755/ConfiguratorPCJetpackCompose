package com.example.configuratorpcjetpackcompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.configuratorpcjetpackcompose.viewmodel.AppViewModel

object AppTheme {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
    val fontFamily: AppFontFamily
        @Composable
        @ReadOnlyComposable
        get() = LocalFontFamily.current
}

@Composable
fun AppTheme(
    typography: AppTypography = AppTheme.typography,
    dimensions: AppDimensions = AppTheme.dimensions,
    fontFamily: AppFontFamily = AppTheme.fontFamily,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors()
    } else {
        lightColors()
    }

    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalFontFamily provides fontFamily,
        LocalTypography provides typography

    ) {
        content()
    }
}