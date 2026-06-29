package com.easteats.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val Ink = Color(0xFF050608)
val Panel = Color(0xFF121317)
val PanelSoft = Color(0xFF191A20)
val Stroke = Color(0xFF2A2C33)
val Muted = Color(0xFF888A93)
val TextPrimary = Color(0xFFF6F7F9)
val Accent = Color(0xFFF23647)
val AccentDeep = Color(0xFF240B10)
val Success = Color(0xFF27D977)
val Gold = Color(0xFFFFB74D)

object EastEatsDimens {
    val ScreenPadding = 20.dp
    val CardRadius = 16.dp
    val ControlRadius = 13.dp
    val BottomNavHeight = 76.dp
    val BottomNavHorizontalInset = 16.dp
    val BottomNavBottomInset = 12.dp
}

@Composable
fun EastEatsTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}
