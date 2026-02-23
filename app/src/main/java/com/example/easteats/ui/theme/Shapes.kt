package com.example.easteats.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp), // Small menu item cards
    medium = RoundedCornerShape(16.dp), //primary buttons & inputs
    large = RoundedCornerShape(20.dp), //menu cards sections
    extraLarge = RoundedCornerShape(24.dp) //modals or bottomsheets
)