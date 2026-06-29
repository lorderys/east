package com.easteats.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.ui.components.ChoiceRow
import com.easteats.app.ui.components.FlowScreen
import com.easteats.app.ui.components.HeaderWithRefresh
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.PanelSoft
import com.easteats.app.ui.theme.TextPrimary

@Composable
fun PlannerScreen(onStart: () -> Unit, onPreferences: () -> Unit, onBudget: () -> Unit) {
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 22.dp, bottom = 156.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item { HeaderWithRefresh("AI Meal Planner") }
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(top = 32.dp)) {
                Box(
                    Modifier
                        .size(132.dp)
                        .clip(CircleShape)
                        .background(Brush.radialGradient(listOf(Color(0xFF9A5863), Color(0xFF4A3038)))),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Outlined.Restaurant, null, tint = Accent, modifier = Modifier.size(42.dp))
                }
                Text("AI Meal Planner", color = TextPrimary, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 28.dp))
                Text(
                    "Tell us your goals and budget. We'll build a custom weekly meal plan in seconds.",
                    color = Color(0xFFC5C7CD),
                    fontSize = 15.sp,
                    lineHeight = 23.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 14.dp)
                )
            }
        }
        item {
            Row(horizontalArrangement = Arrangement.spacedBy(14.dp), modifier = Modifier.fillMaxWidth()) {
                PlannerCard("Budget Smart", Icons.Outlined.CreditCard, onBudget, Modifier.weight(1f))
                PlannerCard("Diet Aligned", Icons.Outlined.Spa, onPreferences, Modifier.weight(1f))
            }
        }
        item { PrimaryButton("Start Planning", onClick = onStart, modifier = Modifier.fillMaxWidth()) }
    }
}


@Composable
fun PreferenceScreen(onBack: () -> Unit, onSave: () -> Unit) {
    var selected by remember { mutableStateOf("Vegan") }
    FlowScreen("Dietary Preferences", onBack, "Save Preference", onSave) {
        listOf(
            "Anything" to "No restrictions",
            "Vegetarian" to "No meat",
            "Vegan" to "No animal products",
            "Keto" to "Low carb, high fat",
            "Paleo" to "Whole foods only"
        ).forEach { (title, sub) ->
            ChoiceRow(title, sub, Icons.Outlined.Spa, selected == title) { selected = title }
        }
    }
}

@Composable
fun BudgetScreen(onBack: () -> Unit, onSave: () -> Unit) {
    var selected by remember { mutableStateOf("Premium") }
    FlowScreen("Weekly Budget", onBack, "Save Budget", onSave) {
        Text("This helps AI suggest meals within your price range.", color = Muted, fontSize = 14.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        listOf("Economy" to "\$50-80 / week", "Balanced" to "\$80-120 / week", "Premium" to "\$120+ / week").forEach { (title, sub) ->
            ChoiceRow(title, sub, Icons.Outlined.CreditCard, selected == title) { selected = title }
        }
    }
}

@Composable
private fun PlannerCard(title: String, icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier
            .height(118.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PanelSoft)
            .clickable(onClick = onClick)
            .padding(18.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, null, tint = Accent, modifier = Modifier.size(31.dp))
        Text(title, color = TextPrimary, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 12.dp))
    }
}

