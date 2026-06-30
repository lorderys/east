package com.easteats.app

import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.easteats.app.model.AppTab
import com.easteats.app.navigation.AppScreen
import com.easteats.app.ui.components.AppFrame
import com.easteats.app.ui.components.FilterBottomSheet
import com.easteats.app.ui.screens.AddressScreen
import com.easteats.app.ui.screens.BudgetScreen
import com.easteats.app.ui.screens.CartScreen
import com.easteats.app.ui.screens.DetailScreen
import com.easteats.app.ui.screens.HomeScreen
import com.easteats.app.ui.screens.LoginScreen
import com.easteats.app.ui.screens.OnboardingScreen
import com.easteats.app.ui.screens.OrderDetailScreen
import com.easteats.app.ui.screens.OrderStatusScreen
import com.easteats.app.ui.screens.OrdersScreen
import com.easteats.app.ui.screens.PaymentScreen
import com.easteats.app.ui.screens.PlannerScreen
import com.easteats.app.ui.screens.PreferenceScreen
import com.easteats.app.ui.screens.ProfileScreen
import com.easteats.app.ui.screens.ReviewScreen
import com.easteats.app.ui.screens.SuccessScreen
import com.easteats.app.ui.theme.EastEatsTheme
import com.easteats.app.ui.theme.Ink

@Composable
fun EastEatsApp() {
    val context = LocalContext.current
    val preferences = remember(context) {
        context.getSharedPreferences("east_eats_preferences", Context.MODE_PRIVATE)
    }
    var screen by remember {
        mutableStateOf<AppScreen>(
            if (preferences.getBoolean("onboarding_complete", false)) {
                AppScreen.Login
            } else {
                AppScreen.Onboarding
            }
        )
    }
    var cartHasItem by remember { mutableStateOf(false) }
    var filtersOpen by remember { mutableStateOf(false) }
    var settingsReturnTab by remember { mutableStateOf(AppTab.Planner) }
    val currentScreen = screen
    val canReturnToMain = currentScreen !is AppScreen.Main &&
        currentScreen !is AppScreen.Onboarding &&
        currentScreen !is AppScreen.Login

    EastEatsTheme {
        Box(Modifier.fillMaxSize().background(Ink)) {
            BackHandler(enabled = filtersOpen) {
                filtersOpen = false
            }

            BackHandler(enabled = !filtersOpen && canReturnToMain) {
                screen = AppScreen.Main(currentScreen.returnTab(settingsReturnTab))
            }

            when (val current = screen) {
                AppScreen.Onboarding -> OnboardingScreen(
                    onDone = {
                        preferences.edit().putBoolean("onboarding_complete", true).apply()
                        screen = AppScreen.Login
                    }
                )
                AppScreen.Login -> LoginScreen(
                    onLogin = { screen = AppScreen.Main(AppTab.Home) }
                )
                is AppScreen.Main -> AppFrame(
                    selected = current.tab,
                    onTab = { screen = AppScreen.Main(it) }
                ) {
                    when (current.tab) {
                        AppTab.Home -> HomeScreen(
                            onFilter = { filtersOpen = true },
                            onMeal = { screen = AppScreen.Detail(it) },
                            onCart = { screen = AppScreen.Cart }
                        )
                        AppTab.Planner -> PlannerScreen(
                            onStart = {
                                settingsReturnTab = AppTab.Planner
                                screen = AppScreen.Dietary
                            },
                            onPreferences = {
                                settingsReturnTab = AppTab.Planner
                                screen = AppScreen.Dietary
                            },
                            onBudget = {
                                settingsReturnTab = AppTab.Planner
                                screen = AppScreen.Budget
                            }
                        )
                        AppTab.Orders -> OrdersScreen(
                            onDetail = { screen = AppScreen.OrderDetail },
                            onTrack = { screen = AppScreen.OrderStatus(false) },
                            onDelivered = { screen = AppScreen.OrderStatus(true) }
                        )
                        AppTab.Profile -> ProfileScreen(
                            onDiet = {
                                settingsReturnTab = AppTab.Profile
                                screen = AppScreen.Dietary
                            },
                            onBudget = {
                                settingsReturnTab = AppTab.Profile
                                screen = AppScreen.Budget
                            }
                        )
                    }
                }
                is AppScreen.Detail -> DetailScreen(
                    meal = current.meal,
                    onBack = { screen = AppScreen.Main(AppTab.Home) },
                    onAdd = {
                        cartHasItem = true
                        screen = AppScreen.Cart
                    }
                )
                AppScreen.Cart -> CartScreen(
                    hasItem = cartHasItem,
                    onBack = { screen = AppScreen.Main(AppTab.Home) },
                    onBrowse = { screen = AppScreen.Main(AppTab.Home) },
                    onCheckout = { screen = AppScreen.ConfirmAddress }
                )
                AppScreen.ConfirmAddress -> AddressScreen(
                    onBack = { screen = AppScreen.Cart },
                    onNext = { screen = AppScreen.Payment }
                )
                AppScreen.Payment -> PaymentScreen(
                    onBack = { screen = AppScreen.ConfirmAddress },
                    onNext = { screen = AppScreen.Review }
                )
                AppScreen.Review -> ReviewScreen(
                    onBack = { screen = AppScreen.Payment },
                    onPlace = { screen = AppScreen.Placed }
                )
                AppScreen.Placed -> SuccessScreen(
                    title = "Order Placed!",
                    subtitle = "Order #8492 is being prepared.",
                    button = "View Order",
                    onDone = { screen = AppScreen.OrderDetail },
                    secondary = "Close",
                    onSecondary = { screen = AppScreen.Main(AppTab.Home) }
                )
                AppScreen.OrderDetail -> OrderDetailScreen(
                    onBack = { screen = AppScreen.Main(AppTab.Orders) },
                    onTrack = { screen = AppScreen.OrderStatus(false) }
                )
                is AppScreen.OrderStatus -> OrderStatusScreen(
                    delivered = current.delivered,
                    onBack = { screen = AppScreen.Main(AppTab.Orders) }
                )
                AppScreen.Dietary -> PreferenceScreen(
                    onBack = { screen = AppScreen.Main(settingsReturnTab) },
                    onSave = { screen = AppScreen.Main(settingsReturnTab) }
                )
                AppScreen.Budget -> BudgetScreen(
                    onBack = { screen = AppScreen.Main(settingsReturnTab) },
                    onSave = { screen = AppScreen.Main(settingsReturnTab) }
                )
            }

            if (filtersOpen) {
                FilterBottomSheet(onClose = { filtersOpen = false })
            }
        }
    }
}

private fun AppScreen.returnTab(settingsReturnTab: AppTab): AppTab = when (this) {
    is AppScreen.Main -> tab
    AppScreen.Onboarding,
    AppScreen.Login -> AppTab.Home
    is AppScreen.Detail,
    AppScreen.Cart,
    AppScreen.ConfirmAddress,
    AppScreen.Payment,
    AppScreen.Review,
    AppScreen.Placed -> AppTab.Home
    AppScreen.OrderDetail,
    is AppScreen.OrderStatus -> AppTab.Orders
    AppScreen.Dietary,
    AppScreen.Budget -> settingsReturnTab
}
