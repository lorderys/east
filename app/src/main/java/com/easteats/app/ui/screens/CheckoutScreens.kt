package com.easteats.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.ui.components.AddPanel
import com.easteats.app.ui.components.CartItem
import com.easteats.app.ui.components.DividerLine
import com.easteats.app.ui.components.FlowScreen
import com.easteats.app.ui.components.PanelBox
import com.easteats.app.ui.components.PriceSummary
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.components.ScreenShell
import com.easteats.app.ui.components.SecondaryButton
import com.easteats.app.ui.components.SelectableHomePanel
import com.easteats.app.ui.components.SelectablePanel
import com.easteats.app.ui.components.StatusBadge
import com.easteats.app.ui.components.SummaryRow
import com.easteats.app.ui.components.TopBar
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.TextPrimary

@Composable
fun CartScreen(hasItem: Boolean, onBack: () -> Unit, onBrowse: () -> Unit, onCheckout: () -> Unit) {
    ScreenShell {
        Column(Modifier.fillMaxSize().padding(20.dp).statusBarsPadding(), horizontalAlignment = Alignment.CenterHorizontally) {
            TopBar("Your Cart", onBack)
            Spacer(Modifier.height(38.dp))
            if (!hasItem) {
                Spacer(Modifier.weight(1f))
                Icon(Icons.Outlined.ShoppingBag, null, tint = Muted)
                Text("Your cart is empty", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 18.dp))
                Text("Looks like you haven't added anything yet.", color = Muted, fontSize = 14.sp, modifier = Modifier.padding(top = 10.dp))
                SecondaryButton("Start Browsing", onBrowse, modifier = Modifier.padding(top = 24.dp))
                Spacer(Modifier.weight(1f))
            } else {
                CartItem()
                PriceSummary()
                Spacer(Modifier.weight(1f))
                PrimaryButton("Checkout", "\$46.99", onCheckout, modifier = Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun AddressScreen(onBack: () -> Unit, onNext: () -> Unit) {
    FlowScreen("Confirm Delivery Address", onBack, "Confirm Address", onNext) {
        SelectableHomePanel()
        SelectablePanel("Office", "456 Corp Blvd", Icons.Outlined.LocationOn, false)
        AddPanel("Add New Address")
    }
}

@Composable
fun PaymentScreen(onBack: () -> Unit, onNext: () -> Unit) {
    FlowScreen("Payment Method", onBack, "Confirm Payment", onNext) {
        SelectablePanel("Visa", "•••• 4242", Icons.Outlined.CreditCard, true)
        SelectablePanel("M-Pesa", "+254799••••877", Icons.AutoMirrored.Outlined.ReceiptLong, false)
        AddPanel("Add Payment Method")
    }
}

@Composable
fun ReviewScreen(onBack: () -> Unit, onPlace: () -> Unit) {
    ScreenShell {
        LazyColumn(
            Modifier.fillMaxSize().padding(horizontal = 20.dp).statusBarsPadding(),
            contentPadding = PaddingValues(bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            item { TopBar("Review Order", onBack) }
            item {
                Text(
                    "Please review your order details before placing it.",
                    color = Muted,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                PanelBox {
                    Text("ORDER SUMMARY", color = Muted, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    SummaryRow("Buddha Bowl", "\$42.50")
                    DividerLine()
                    InfoChange("Delivering to", "Home • 123 Main St")
                    InfoChange("Pay with", "Visa •••• 4242")
                    DividerLine()
                    SummaryRow("Subtotal", "\$42.50", muted = true)
                    SummaryRow("Delivery Fee", "\$2.99", muted = true)
                    SummaryRow("Service Fee", "\$1.50", muted = true)
                    DividerLine()
                    SummaryRow("Total", "\$46.99", large = true)
                }
            }
            item { PrimaryButton("Place Order", "\$46.99", onPlace, Modifier.fillMaxWidth()) }
            item { SecondaryButton("Close", onBack, Modifier.fillMaxWidth()) }
        }
    }
}

@Composable
fun SuccessScreen(
    title: String,
    subtitle: String,
    button: String,
    onDone: () -> Unit,
    secondary: String,
    onSecondary: () -> Unit,
    success: Boolean = true
) {
    ScreenShell {
        Column(Modifier.fillMaxSize().padding(26.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.weight(1f))
            StatusBadge(delivered = success)
            Text(title, color = TextPrimary, fontSize = 25.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 30.dp))
            Text(subtitle, color = Muted, fontSize = 14.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top = 9.dp))
            Spacer(Modifier.weight(1f))
            PrimaryButton(button, onClick = onDone, modifier = Modifier.fillMaxWidth())
            SecondaryButton(secondary, onSecondary, Modifier.fillMaxWidth().padding(top = 14.dp))
        }
    }
}

@Composable
private fun InfoChange(title: String, subtitle: String) {
    androidx.compose.foundation.layout.Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 5.dp))
        }
        Text("Change", color = com.easteats.app.ui.theme.Accent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}
