package com.easteats.app.navigation

import com.easteats.app.model.AppTab
import com.easteats.app.model.Meal

sealed interface AppScreen {
    data object Onboarding : AppScreen
    data object Login : AppScreen
    data class Main(val tab: AppTab) : AppScreen
    data class Detail(val meal: Meal) : AppScreen
    data object Cart : AppScreen
    data object ConfirmAddress : AppScreen
    data object Payment : AppScreen
    data object Review : AppScreen
    data object Placed : AppScreen
    data object OrderDetail : AppScreen
    data class OrderStatus(val delivered: Boolean) : AppScreen
    data object Dietary : AppScreen
    data object Budget : AppScreen
}
