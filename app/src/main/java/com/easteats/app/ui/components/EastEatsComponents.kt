package com.easteats.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ReceiptLong
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.DeliveryDining
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Minimize
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.MyLocation
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.data.DummyData
import com.easteats.app.model.AppTab
import com.easteats.app.model.Category
import com.easteats.app.model.Meal
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.AccentDeep
import com.easteats.app.ui.theme.EastEatsDimens
import com.easteats.app.ui.theme.Gold
import com.easteats.app.ui.theme.Ink
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.PanelSoft
import com.easteats.app.ui.theme.Stroke
import com.easteats.app.ui.theme.Success
import com.easteats.app.ui.theme.TextPrimary

@Composable
fun ScreenShell(content: @Composable BoxScope.() -> Unit) {
    Box(Modifier.fillMaxSize().background(Ink), content = content)
}

@Composable
fun AppFrame(selected: AppTab, onTab: (AppTab) -> Unit, content: @Composable () -> Unit) {
    Box(Modifier.fillMaxSize().background(Ink)) {
        content()
        BottomNav(
            selected = selected,
            onTab = onTab,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomNav(selected: AppTab, onTab: (AppTab) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier
            .navigationBarsPadding()
            .padding(
                start = EastEatsDimens.BottomNavHorizontalInset,
                end = EastEatsDimens.BottomNavHorizontalInset,
                bottom = EastEatsDimens.BottomNavBottomInset
            )
            .fillMaxWidth()
            .height(EastEatsDimens.BottomNavHeight)
            .shadow(18.dp, RoundedCornerShape(24.dp), clip = false)
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xF20C0D10))
            .border(1.dp, Color.White.copy(alpha = 0.07f), RoundedCornerShape(24.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem(AppTab.Home, selected, Icons.Outlined.Home, "Home", onTab)
        NavItem(AppTab.Planner, selected, Icons.Outlined.Restaurant, "Planner", onTab)
        NavItem(AppTab.Orders, selected, Icons.AutoMirrored.Outlined.ReceiptLong, "Orders", onTab)
        NavItem(AppTab.Profile, selected, Icons.Outlined.Person, "Profile", onTab)
    }
}

@Composable
private fun NavItem(tab: AppTab, selected: AppTab, icon: ImageVector, label: String, onTab: (AppTab) -> Unit) {
    val active = tab == selected
    Column(
        Modifier
            .width(68.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onTab(tab) }
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(icon, null, tint = if (active) Accent else Muted, modifier = Modifier.size(24.dp))
        Text(label, color = if (active) Accent else Muted, fontSize = 11.sp, modifier = Modifier.padding(top = 4.dp))
    }
}

@Composable
fun HomeHeader(onCart: () -> Unit) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.weight(1f)) {
            Text("DELIVERING TO", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Home • 123 Main St", color = Accent, fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
                Icon(Icons.Outlined.LocationOn, null, tint = Accent, modifier = Modifier.size(16.dp))
            }
        }
        RoundIcon(Icons.AutoMirrored.Outlined.ReceiptLong, onClick = onCart, badge = true)
        Spacer(Modifier.width(10.dp))
        RoundIcon(Icons.Outlined.DeliveryDining, onClick = onCart, badge = true)
    }
}

@Composable
fun HeaderWithRefresh(title: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = TextPrimary, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
        RoundIcon(Icons.Outlined.FilterList, onClick = {})
    }
}

@Composable
fun TopBar(title: String, onBack: () -> Unit) {
    Row(Modifier.fillMaxWidth().height(52.dp), verticalAlignment = Alignment.CenterVertically) {
        RoundIcon(Icons.AutoMirrored.Rounded.ArrowBack, onClick = onBack)
        Text(
            title,
            color = TextPrimary,
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.size(42.dp))
    }
}

@Composable
fun SearchBar(onFilter: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PanelSoft)
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Outlined.Search, null, tint = Muted, modifier = Modifier.size(22.dp))
        Text("What are you craving?", color = Muted, fontSize = 15.sp, modifier = Modifier.padding(start = 10.dp).weight(1f))
        IconButton(onClick = onFilter) {
            Icon(Icons.Outlined.Tune, null, tint = TextPrimary)
        }
    }
}

@Composable
fun CategoryStrip(categories: List<Category>) {
    SectionTitle("Categories", "See all")
    Spacer(Modifier.height(12.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(categories) { category ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    Modifier.size(58.dp).clip(RoundedCornerShape(18.dp)).background(PanelSoft),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(category.icon, null, tint = Muted, modifier = Modifier.size(27.dp))
                }
                Text(category.label, color = Muted, fontSize = 11.sp, modifier = Modifier.padding(top = 8.dp))
            }
        }
    }
}

@Composable
fun MealSection(title: String, meals: List<Meal>, onMeal: (Meal) -> Unit) {
    SectionTitle(title, "See all")
    Spacer(Modifier.height(12.dp))
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(14.dp)) {
        meals.forEach { meal ->
            MealCard(meal = meal, modifier = Modifier.weight(1f), onClick = { onMeal(meal) })
        }
    }
}

@Composable
fun MealCard(meal: Meal, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(
        modifier
            .height(214.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PanelSoft)
            .clickable(onClick = onClick)
    ) {
        Box(Modifier.fillMaxWidth().height(118.dp)) {
            ImageSlot(meal.image, Modifier.fillMaxSize())
            Pill(meal.minutes, Modifier.align(Alignment.TopStart).padding(8.dp), dark = false)
        }
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(meal.name, color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, maxLines = 1, overflow = TextOverflow.Ellipsis, modifier = Modifier.weight(1f))
                Text(meal.price, color = Accent, fontSize = 13.sp, fontWeight = FontWeight.ExtraBold)
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Outlined.Star, null, tint = Gold, modifier = Modifier.size(14.dp))
                Text(meal.rating, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(start = 4.dp))
                Text(" • ${meal.subtitle}", color = Muted, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun ImageSlot(image: Int, modifier: Modifier = Modifier) {
    Box(
        modifier.background(PanelSoft)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun RoundIcon(icon: ImageVector, onClick: () -> Unit, modifier: Modifier = Modifier, badge: Boolean = false) {
    Box(
        modifier
            .size(42.dp)
            .clip(CircleShape)
            .background(PanelSoft)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, null, tint = TextPrimary, modifier = Modifier.size(20.dp))
        if (badge) {
            Box(Modifier.align(Alignment.TopEnd).size(13.dp).clip(CircleShape).background(Accent))
        }
    }
}

@Composable
fun PrimaryButton(text: String, value: String? = null, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.height(58.dp),
        shape = RoundedCornerShape(EastEatsDimens.ControlRadius),
        colors = ButtonDefaults.buttonColors(containerColor = Accent, contentColor = Color.White),
        contentPadding = PaddingValues(horizontal = 18.dp)
    ) {
        Text(text, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold, modifier = if (value != null) Modifier.weight(1f) else Modifier)
        if (value != null) {
            Text(value, fontSize = 15.sp, fontWeight = FontWeight.ExtraBold)
            Icon(Icons.AutoMirrored.Rounded.ArrowForward, null, modifier = Modifier.padding(start = 8.dp).size(18.dp))
        }
    }
}

@Composable
fun SecondaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, light: Boolean = false) {
    Button(
        onClick = onClick,
        modifier = modifier.height(46.dp),
        shape = RoundedCornerShape(11.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (light) Color.White else PanelSoft,
            contentColor = if (light) Accent else TextPrimary
        )
    ) {
        Text(text, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Clip)
    }
}

@Composable
fun CompactButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier, height: Dp = 40.dp) {
    Button(
        onClick = onClick,
        modifier = modifier.height(height),
        shape = RoundedCornerShape(11.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PanelSoft, contentColor = TextPrimary),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Text(text, fontSize = 13.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Clip)
    }
}

@Composable
fun LabelChip(label: String, selected: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier
            .height(48.dp)
            .clip(RoundedCornerShape(13.dp))
            .background(if (selected) AccentDeep else Color.Transparent)
            .border(1.dp, if (selected) Accent else Stroke, RoundedCornerShape(13.dp))
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(label, color = if (selected) Accent else TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
    }
}

@Composable
fun PanelBox(content: @Composable ColumnScope.() -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(PanelSoft)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
        content = content
    )
}

@Composable
fun DividerLine() {
    Box(Modifier.fillMaxWidth().height(1.dp).background(Stroke.copy(alpha = 0.7f)))
}

@Composable
fun SummaryRow(label: String, value: String, muted: Boolean = false, large: Boolean = false) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(label, color = if (muted) Muted else TextPrimary, fontSize = if (large) 18.sp else 14.sp, fontWeight = if (large) FontWeight.ExtraBold else FontWeight.Medium, modifier = Modifier.weight(1f))
        Text(value, color = TextPrimary, fontSize = if (large) 18.sp else 14.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun QuantityStepper(value: Int, onMinus: () -> Unit, onPlus: () -> Unit, compact: Boolean = false) {
    Row(
        Modifier
            .height(if (compact) 34.dp else 48.dp)
            .clip(CircleShape)
            .background(PanelSoft)
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Icon(Icons.Outlined.Minimize, null, tint = TextPrimary, modifier = Modifier.size(17.dp).clickable(onClick = onMinus))
        Text("$value", color = TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
        Box(Modifier.size(if (compact) 24.dp else 34.dp).clip(CircleShape).background(Accent).clickable(onClick = onPlus), contentAlignment = Alignment.Center) {
            Icon(Icons.Outlined.Add, null, tint = Color.White, modifier = Modifier.size(18.dp))
        }
    }
}

@Composable
fun SelectablePanel(title: String, subtitle: String, icon: ImageVector, selected: Boolean) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(86.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(if (selected) AccentDeep else PanelSoft)
            .border(1.dp, if (selected) Accent else Color.Transparent, RoundedCornerShape(14.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, null, tint = if (selected) Accent else Muted, modifier = Modifier.size(28.dp))
        Column(Modifier.padding(start = 16.dp).weight(1f)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.ExtraBold)
            Text(subtitle, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 6.dp))
        }
        Icon(Icons.Outlined.CheckCircle, null, tint = if (selected) Accent else Muted)
    }
}

@Composable
fun AddPanel(title: String) {
    Row(
        Modifier.fillMaxWidth().height(58.dp).clip(RoundedCornerShape(12.dp)).background(PanelSoft),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Outlined.Add, null, tint = TextPrimary, modifier = Modifier.size(18.dp))
        Text(title, color = TextPrimary, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ChoiceRow(title: String, subtitle: String, icon: ImageVector, selected: Boolean, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) AccentDeep else PanelSoft)
            .border(1.dp, if (selected) Accent else Color.Transparent, RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.size(40.dp).clip(CircleShape).background(Color(0xFF25272F)), contentAlignment = Alignment.Center) {
            Icon(icon, null, tint = if (selected) Accent else Muted, modifier = Modifier.size(21.dp))
        }
        Column(Modifier.padding(start = 14.dp).weight(1f)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.ExtraBold, lineHeight = 20.sp)
            Text(subtitle, color = Muted, fontSize = 12.sp, lineHeight = 17.sp, modifier = Modifier.padding(top = 6.dp))
        }
        if (selected) Box(Modifier.size(12.dp).clip(CircleShape).background(Accent))
    }
}

@Composable
fun FlowScreen(title: String, onBack: () -> Unit, cta: String, onCta: () -> Unit, content: @Composable ColumnScope.() -> Unit) {
    ScreenShell {
        Column(Modifier.fillMaxSize().padding(EastEatsDimens.ScreenPadding).statusBarsPadding().navigationBarsPadding()) {
            TopBar(title, onBack)
            Spacer(Modifier.height(34.dp))
            Column(
                Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                content = content
            )
            PrimaryButton(cta, onClick = onCta, modifier = Modifier.fillMaxWidth())
            SecondaryButton("Close", onBack, Modifier.fillMaxWidth().padding(top = 12.dp))
        }
    }
}

@Composable
fun Pill(text: String, modifier: Modifier = Modifier, dark: Boolean = true) {
    Box(
        modifier
            .clip(CircleShape)
            .background(if (dark) AccentDeep else Color.White.copy(alpha = 0.9f))
            .padding(horizontal = 9.dp, vertical = 5.dp)
    ) {
        Text(text, color = if (dark) Accent else Ink, fontSize = 10.sp, fontWeight = FontWeight.ExtraBold)
    }
}

@Composable
fun FilterBottomSheet(onClose: () -> Unit) {
    Box(Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.72f)).clickable(onClick = onClose)) {
        Column(
            Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp))
                .background(Color(0xFF0C0D10))
                .clickable(enabled = false) {}
                .navigationBarsPadding()
                .padding(horizontal = 20.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.width(82.dp).height(5.dp).clip(CircleShape).background(Stroke))
            Text("Filters", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.padding(top = 28.dp, bottom = 26.dp))
            SheetLabel("Sort by")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                LabelChip("Recommended", true)
                LabelChip("Rating", false)
                LabelChip("Delivery Time", false)
            }
            Spacer(Modifier.height(24.dp))
            SheetLabel("Price Range")
            Box(Modifier.fillMaxWidth().height(38.dp)) {
                Box(Modifier.align(Alignment.Center).fillMaxWidth().height(4.dp).clip(CircleShape).background(Stroke))
                Box(Modifier.align(Alignment.CenterStart).fillMaxWidth(0.55f).height(5.dp).clip(CircleShape).background(Accent))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("\$", color = Muted)
                    Text("\$\$\$\$", color = Muted)
                }
            }
            Spacer(Modifier.height(20.dp))
            SheetLabel("Dietary")
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                LabelChip("Vegetarian", false)
                LabelChip("Vegan", true)
                LabelChip("Gluten-free", false)
            }
            Spacer(Modifier.height(28.dp))
            PrimaryButton("Apply Filters", onClick = onClose, modifier = Modifier.fillMaxWidth())
            SecondaryButton("Close", onClose, Modifier.fillMaxWidth().padding(top = 14.dp))
        }
    }
}

@Composable
private fun SectionTitle(title: String, action: String) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(title, color = TextPrimary, fontSize = 17.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.weight(1f))
        Text(action, color = Accent, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun SheetLabel(text: String) {
    Text(text, color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp))
}

@Composable
fun CartItem() {
    PanelBox {
        Row(verticalAlignment = Alignment.CenterVertically) {
            ImageSlot(DummyData.meals.first().image, Modifier.size(78.dp).clip(RoundedCornerShape(14.dp)))
            Column(Modifier.padding(start = 14.dp).weight(1f)) {
                Text("Buddha Bowl", color = TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
                QuantityStepper(1, {}, {}, compact = true)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text("\$42.50", color = TextPrimary, fontWeight = FontWeight.Bold)
                Icon(Icons.Outlined.Delete, null, tint = Muted, modifier = Modifier.padding(top = 22.dp).size(18.dp))
            }
        }
    }
}

@Composable
fun PriceSummary() {
    PanelBox {
        SummaryRow("Subtotal", "\$42.50", muted = true)
        SummaryRow("Delivery Fee", "\$2.99", muted = true)
        SummaryRow("Service Fee", "\$1.50", muted = true)
        DividerLine()
        SummaryRow("Total", "\$46.99", large = true)
    }
}

@Composable
fun StatusBadge(delivered: Boolean) {
    Box(
        Modifier
            .size(112.dp)
            .clip(CircleShape)
            .background(Color(0xFFE4FFE8)),
        contentAlignment = Alignment.Center
    ) {
        Icon(Icons.Rounded.Check, null, tint = if (delivered) Success else Accent, modifier = Modifier.size(54.dp))
    }
}

@Composable
fun InfoMeta(title: String, subtitle: String, icon: ImageVector) {
    Row(Modifier.fillMaxWidth().padding(vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, null, tint = Muted, modifier = Modifier.size(21.dp))
        Column(Modifier.padding(start = 14.dp)) {
            Text(title, color = TextPrimary, fontWeight = FontWeight.Bold)
            if (subtitle.isNotBlank()) Text(subtitle, color = Muted, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
        }
    }
}

@Composable
fun SelectableHomePanel(selected: Boolean = true) {
    SelectablePanel("Home", "123 Main St, Apt 4B", Icons.Rounded.MyLocation, selected)
}

@Composable
fun SelectableRadio(selected: Boolean) {
    Icon(if (selected) Icons.Rounded.Circle else Icons.Outlined.RadioButtonUnchecked, null, tint = if (selected) Accent else Muted)
}
