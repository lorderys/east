package com.example.easteats.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class AppElevation(
    val flat: Dp = 0.dp,
    val card: Dp = 1.dp,  //"opacity": 0.08, "color": Black40
    val float: Dp = 4.dp, //"opacity": 0.12, "color": Black40
    val modal: Dp = 8.dp //"opacity": 0.16, "color": Black40
)