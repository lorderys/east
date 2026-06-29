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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Logout
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.easteats.app.ui.components.HeaderWithRefresh
import com.easteats.app.ui.components.PanelBox
import com.easteats.app.ui.components.Pill
import com.easteats.app.ui.components.SecondaryButton
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.PanelSoft
import com.easteats.app.ui.theme.TextPrimary


@Composable
fun ProfileScreen(onDiet: () -> Unit, onBudget: () -> Unit) {
    LazyColumn(
        modifier = Modifier.statusBarsPadding(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 22.dp, bottom = 156.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item { HeaderWithRefresh("Profile") }
        item {
            PanelBox {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("Jane Doe", color = TextPrimary, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("jane.doe@example.com", color = Muted, fontSize = 13.sp, modifier = Modifier.padding(top = 4.dp))
                    }
                    SecondaryButton("Edit", {}, Modifier.width(78.dp))
                }
            }
        }
        item {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(154.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Brush.horizontalGradient(listOf(Accent, Color(0xFFFF5A18))))
                    .padding(20.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Upgrade to Pro", color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
                        Pill("PRO", dark = false)
                    }
                    Text("Free delivery, 2x meal planning credits,\nand exclusive recipes.", color = Color.White.copy(alpha = 0.84f), fontSize = 14.sp, lineHeight = 21.sp, modifier = Modifier.padding(top = 12.dp))
                    SecondaryButton("Try Free for 1 Month", {}, Modifier.width(190.dp).padding(top = 16.dp), light = true)
                }
            }
        }
        item {
            SectionLabel("ACCOUNT")
            ProfileRow("Payment Methods", "Visa •••• 4242", Icons.Outlined.CreditCard) {}
            ProfileRow("Addresses", "Home", Icons.Outlined.LocationOn) {}
            ProfileRow("Notifications", "", Icons.Outlined.Notifications) {}
        }
        item {
            SectionLabel("PREFERENCES")
            ProfileRow("Dietary Settings", "Not Set", Icons.Outlined.Settings, onDiet)
            ProfileRow("Budget", "Premium", Icons.Outlined.CreditCard, onBudget)
            ProfileRow("Health Goals", "Not Set", Icons.Outlined.FitnessCenter) {}
            ProfileRow("Allergies", "None", Icons.Outlined.ErrorOutline) {}
            ProfileRow("Privacy & Security", "", Icons.Outlined.Lock) {}
        }
        item {
            SectionLabel("SUPPORT")
            ProfileRow("Help Center", "", Icons.Outlined.ErrorOutline) {}
            ProfileRow("Log Out", "", Icons.AutoMirrored.Outlined.Logout) {}
            Text("Version 1.0.0", color = Muted, fontSize = 11.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth().padding(top = 24.dp))
        }
    }
}



@Composable
private fun ProfileRow(title: String, value: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(68.dp)
            .clip(RoundedCornerShape(14.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(42.dp).clip(CircleShape).background(PanelSoft), contentAlignment = Alignment.Center) {
            Icon(icon, null, tint = Muted, modifier = Modifier.size(21.dp))
        }
        Text(title, color = TextPrimary, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 14.dp).weight(1f))
        if (value.isNotBlank()) Text(value, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(end = 8.dp))
        Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, tint = Muted, modifier = Modifier.size(18.dp))
    }
}

@Composable
private fun SectionLabel(text: String) {
    Text(text, color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
}