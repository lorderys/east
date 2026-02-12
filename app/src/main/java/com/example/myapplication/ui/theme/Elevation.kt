package com.example.myapplication.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class AppElevation(
    val flat: Dp = 0.dp,
    val card: Dp = 1.dp,
    val float: Dp = 4.dp,
    val modal: Dp = 8.dp
)