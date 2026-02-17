package com.example.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryOrange,
    onPrimary = DarkOrange,
    surface = LightOrange,
    secondary = DarkOrange,
    onSecondary = Success,
    background = BackgroundDt,
    onSurface = Black20,
    surfaceVariant = Black60,
    outline = Black80,
    error = Error,
    onError = Warning,
    onBackground = Text40,
    tertiary = TextTertiary20,
    onTertiary = Premium

)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryOrange,
    onPrimary = DarkOrange,
    surface = LightOrange,
    secondary = DarkOrange,
    onSecondary = Success,
    background = BackgroundLt,
    onSurface = White20,
    surfaceVariant = Gray200,
    outline = White80,
    error = Error,
    onError = Warning,
    onBackground = Black40,
    tertiary = TextTertiary,
    onTertiary = Premium
)

enum class Theme {
    SYSTEM,
    LIGHT,
    DARK
}

@Composable
fun EastTheme(
    theme: Theme,
    content: @Composable () -> Unit
) {

    val enterDarkMode = when (theme) {
        Theme.SYSTEM -> isSystemInDarkTheme()
        Theme.LIGHT -> false
        Theme.DARK -> true
    }

    val colorScheme = if(enterDarkMode) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as android.app.Activity).window

            window.statusBarColor = colorScheme.background.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()

            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                !enterDarkMode
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !enterDarkMode
        }
    }

    val LocalSpacing = staticCompositionLocalOf { AppSpacing() }
    val LocalElevation = staticCompositionLocalOf { AppElevation() }
    val LocalDimens = staticCompositionLocalOf { Dimens() }

    CompositionLocalProvider(
        LocalSpacing provides AppSpacing(),
        LocalDimens provides Dimens(),
        LocalElevation provides AppElevation()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = shapes,
            content = content
        )
    }
}