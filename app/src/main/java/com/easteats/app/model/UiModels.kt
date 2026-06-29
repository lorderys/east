package com.easteats.app.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Meal(
    val name: String,
    val subtitle: String,
    val price: String,
    val minutes: String,
    val rating: String,
    val image: Int
)

data class Category(
    val label: String,
    val icon: ImageVector
)

enum class AppTab {
    Home,
    Planner,
    Orders,
    Profile
}
