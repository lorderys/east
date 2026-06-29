package com.easteats.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.outlined.DeliveryDining
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.model.Meal
import com.easteats.app.ui.components.DividerLine
import com.easteats.app.ui.components.ImageSlot
import com.easteats.app.ui.components.LabelChip
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.components.QuantityStepper
import com.easteats.app.ui.components.RoundIcon
import com.easteats.app.ui.components.ScreenShell
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.Gold
import com.easteats.app.ui.theme.Ink
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.Stroke
import com.easteats.app.ui.theme.TextPrimary

@Composable
fun DetailScreen(meal: Meal, onBack: () -> Unit, onAdd: () -> Unit) {
    var quantity by remember { mutableIntStateOf(1) }

    ScreenShell {
        LazyColumn(contentPadding = PaddingValues(bottom = 132.dp)) {
            item {
                Box(Modifier.fillMaxWidth().height(356.dp)) {
                    ImageSlot(meal.image, Modifier.fillMaxSize())
                    RoundIcon(Icons.AutoMirrored.Rounded.ArrowBack, onClick = onBack, modifier = Modifier.align(Alignment.TopStart).statusBarsPadding().padding(18.dp))
                    RoundIcon(Icons.Outlined.Star, onClick = {}, modifier = Modifier.align(Alignment.TopEnd).statusBarsPadding().padding(18.dp))
                }
            }
            item {
                Column(Modifier.padding(20.dp), verticalArrangement = Arrangement.spacedBy(22.dp)) {
                    Text(meal.name, color = TextPrimary, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                    Text(
                        "Succulent grilled goat meat served with traditional ugali, kachumbari salad, and sauteed spinach. A Kenyan classic perfect for sharing.",
                        color = Color(0xFFC5C7CD),
                        fontSize = 15.sp,
                        lineHeight = 24.sp
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                        DetailMeta(Icons.Outlined.Star, meal.rating, Gold)
                        DetailMeta(Icons.Outlined.DeliveryDining, "Free Delivery", Accent)
                        DetailMeta(Icons.Rounded.Schedule, meal.minutes, Accent)
                    }
                    DividerLine()
                    Text("Size", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        listOf("Small", "Regular", "Large").forEach {
                            LabelChip(it, selected = it == "Regular", modifier = Modifier.weight(1f))
                        }
                    }
                    Text("Add-ons", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                    AddOnRow("Extra Ugali", "+KES 100", meal.image)
                    AddOnRow("Kachumbari", "+KES 50", meal.image)
                    AddOnRow("Chili Sauce", "Free", meal.image)
                }
            }
        }

        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Brush.verticalGradient(listOf(Color.Transparent, Ink, Ink)))
                .padding(20.dp)
                .navigationBarsPadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            QuantityStepper(quantity, onMinus = { if (quantity > 1) quantity-- }, onPlus = { quantity++ })
            Spacer(Modifier.width(16.dp))
            PrimaryButton("Add to Cart", "KES 1,450", onClick = onAdd, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun AddOnRow(title: String, price: String, image: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, Stroke, RoundedCornerShape(14.dp))
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageSlot(image, Modifier.size(48.dp).clip(RoundedCornerShape(12.dp)))
        Column(Modifier.padding(start = 14.dp).weight(1f)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.Bold)
            Text(price, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
        }
        Icon(Icons.Outlined.Star, null, tint = Muted)
    }
}

@Composable
private fun DetailMeta(icon: ImageVector, label: String, tint: Color) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = tint, modifier = Modifier.size(18.dp))
        Text(label, color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 6.dp))
    }
}
