package com.easteats.app.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocalDining
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Whatshot
import com.easteats.app.R
import com.easteats.app.model.Category
import com.easteats.app.model.Meal

object DummyData {
    val categories = listOf(
        Category("Healthy", Icons.Outlined.Spa),
        Category("Vegan", Icons.Outlined.LocalDining),
        Category("Sushi", Icons.Outlined.Restaurant),
        Category("Burgers", Icons.Outlined.ShoppingBag),
        Category("Pizza", Icons.Rounded.Whatshot),
        Category("Dessert", Icons.Outlined.Star)
    )

    val meals = listOf(
        Meal("Buddha Bowl", "Healthy", "\$14.99", "20 min", "4.8", R.drawable.buddhabowl),
        Meal("Salmon Poke", "Fresh", "\$16.50", "25 min", "4.7", R.drawable.salmonpoke),
        Meal("Avocado Toast", "Breakfast", "\$12.00", "15 min", "4.6", R.drawable.avocadotoast),
        Meal("Veggie Burger", "Popular", "\$15.00", "30 min", "4.5", R.drawable.veggieburger),
        Meal("Quinoa Power Bowl", "Tasty & Delicious", "KES 1,450", "25-35 min", "4.8", R.drawable.container),
        Meal("Butter Fried Shrimp", "Seafood", "\$28.90", "35 min", "4.9", R.drawable.container3)
    )
}
