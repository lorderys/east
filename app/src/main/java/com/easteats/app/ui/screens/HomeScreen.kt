package com.easteats.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.easteats.app.data.DummyData
import com.easteats.app.model.Meal
import com.easteats.app.ui.components.CategoryStrip
import com.easteats.app.ui.components.HomeHeader
import com.easteats.app.ui.components.MealSection
import com.easteats.app.ui.components.SearchBar
import com.easteats.app.ui.theme.EastEatsDimens

@Composable
fun HomeScreen(onFilter: () -> Unit, onMeal: (Meal) -> Unit, onCart: () -> Unit) {
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        contentPadding = PaddingValues(
            start = EastEatsDimens.ScreenPadding,
            end = EastEatsDimens.ScreenPadding,
            top = EastEatsDimens.ScreenPadding,
            bottom = 156.dp
        ),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        item { HomeHeader(onCart = onCart) }
        item { SearchBar(onFilter = onFilter) }
        item { CategoryStrip(DummyData.categories) }
        item { MealSection("Featured for you", DummyData.meals.take(2), onMeal) }
        item { MealSection("Popular Nearby", DummyData.meals.drop(2).take(2), onMeal) }
        item { MealSection("Quick Picks", DummyData.meals.drop(4).take(2), onMeal) }
    }
}
