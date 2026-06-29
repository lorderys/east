package com.easteats.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.data.DummyData
import com.easteats.app.ui.components.CompactButton
import com.easteats.app.ui.components.DividerLine
import com.easteats.app.ui.components.HeaderWithRefresh
import com.easteats.app.ui.components.ImageSlot
import com.easteats.app.ui.components.InfoMeta
import com.easteats.app.ui.components.PanelBox
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.components.ScreenShell
import com.easteats.app.ui.components.SecondaryButton
import com.easteats.app.ui.components.SummaryRow
import com.easteats.app.ui.components.TopBar
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.PanelSoft
import com.easteats.app.ui.theme.Stroke
import com.easteats.app.ui.theme.Success
import com.easteats.app.ui.theme.TextPrimary

@Composable
fun OrdersScreen(onDetail: () -> Unit, onTrack: () -> Unit, onDelivered: () -> Unit) {
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 22.dp, bottom = 156.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { HeaderWithRefresh("Your Orders") }
        item {
            Text("Order in Progress", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Arriving in 15-20 min", color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 5.dp))
            OrderProgressCard(onDetail, onTrack)
        }
        item {
            Text("Past Orders", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(12.dp))
            PastOrder("Butter Fried Shrimp", "\$28.90", "Yesterday", onDelivered)
            PastOrder("Garlic Dough Pizza", "\$55.00", "Mon, Oct 24", onDelivered)
        }
    }
}

@Composable
fun OrderDetailScreen(onBack: () -> Unit, onTrack: () -> Unit) {
    ScreenShell {
        LazyColumn(
            modifier = Modifier.statusBarsPadding().padding(horizontal = 20.dp),
            contentPadding = PaddingValues(bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item { TopBar("Order Details", onBack) }
            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Rounded.Schedule, null, tint = Accent, modifier = Modifier.size(52.dp))
                    Text("Order in Progress", color = TextPrimary, fontSize = 21.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 14.dp))
                    Text("Today, 12:30 PM", color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 5.dp))
                }
            }
            item {
                DividerLine()
                Text("ITEMS", color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 18.dp))
                SummaryRow("1x Quinoa Power Bowl", "--", muted = true)
                SummaryRow("1x Berry Smoothie", "--", muted = true)
                SummaryRow("1x Avocado Toast", "--", muted = true)
                DividerLine()
                InfoMeta("Delivery Address", "Home • 123 Main St", Icons.Outlined.LocationOn)
                InfoMeta("Estimated Arrival", "12:45 PM - 1:00 PM", Icons.Rounded.Schedule)
                Spacer(Modifier.height(26.dp))
                InfoMeta("Report an Issue", "", Icons.Outlined.ErrorOutline)
                InfoMeta("Download Receipt", "", Icons.AutoMirrored.Outlined.ReceiptLong)
            }
            item { PrimaryButton("Track Order", onClick = onTrack, modifier = Modifier.fillMaxWidth()) }
        }
    }
}

@Composable
fun OrderStatusScreen(delivered: Boolean, onBack: () -> Unit) {
    SuccessScreen(
        title = if (delivered) "Order Delivered" else "Order Placed!",
        subtitle = if (delivered) "Mon, Oct 24" else "Order #8492 is being prepared.",
        button = if (delivered) "Reorder Now" else "View Order",
        onDone = onBack,
        secondary = if (delivered) "Rate Order" else "Track Order",
        onSecondary = onBack,
        success = delivered
    )
}

@Composable
private fun OrderProgressCard(onDetail: () -> Unit, onTrack: () -> Unit) {
    PanelBox {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageSlot(DummyData.meals[4].image, Modifier.size(72.dp).clip(RoundedCornerShape(14.dp)))
            Column(Modifier.padding(start = 14.dp).weight(1f)) {
                Text("Lamb Chops", color = TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                Text("3 items • \$42.50", color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
            }
            CompactButton("Track", onTrack, Modifier.width(92.dp))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            listOf("CONFIRMED", "COOKING", "ON WAY", "DELIVERED").forEachIndexed { index, label ->
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    androidx.compose.foundation.layout.Box(
                        Modifier
                            .fillMaxWidth(0.18f)
                            .height(4.dp)
                            .clip(CircleShape)
                            .background(if (index < 2) Accent else Stroke)
                    )
                    Text(label, color = if (index < 2) Accent else Muted, fontSize = 9.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
        SecondaryButton("Order Details", onDetail, Modifier.fillMaxWidth())
    }
}

@Composable
private fun PastOrder(title: String, price: String, date: String, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(114.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PanelSoft)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageSlot(DummyData.meals[title.length % DummyData.meals.size].image, Modifier.size(70.dp).clip(RoundedCornerShape(14.dp)))
        Column(Modifier.padding(start = 14.dp).weight(1f)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.ExtraBold, lineHeight = 20.sp)
            Text(date, color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp))
            Text("Delivered", color = Success, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp))
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(price, color = TextPrimary, fontWeight = FontWeight.Bold)
            RatingChip(Modifier.padding(top = 16.dp))
        }
    }
}

@Composable
private fun RatingChip(modifier: Modifier = Modifier) {
    Row(
        modifier
            .height(28.dp)
            .clip(CircleShape)
            .background(com.easteats.app.ui.theme.AccentDeep)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Icon(Icons.Outlined.Star, null, tint = Accent, modifier = Modifier.size(13.dp))
        Text("5", color = Accent, fontSize = 12.sp, fontWeight = FontWeight.ExtraBold)
    }
}
