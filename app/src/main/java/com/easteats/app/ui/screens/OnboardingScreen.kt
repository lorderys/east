package com.easteats.app.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Restaurant
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.R
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.theme.Accent

private data class OnboardingPage(
    @param:DrawableRes val background: Int,
    val icon: ImageVector,
    val title: String,
    val body: String,
    val button: String
)

@Composable
fun OnboardingScreen(onDone: () -> Unit) {
    val pages = remember {
        listOf(
            OnboardingPage(
                background = R.drawable.background_01,
                icon = Icons.Outlined.Restaurant,
                title = "Delicious meals,\ndelivered instantly.",
                body = "Chef-curated menus from top kitchens\ndirectly to your door.",
                button = "Next"
            ),
            OnboardingPage(
                background = R.drawable.background_02,
                icon = Icons.Outlined.AutoAwesome,
                title = "AI-Powered\nMeal Planning",
                body = "Personalized weekly plans in seconds based\non your goals and budget.",
                button = "Next"
            ),
            OnboardingPage(
                background = R.drawable.background_03,
                icon = Icons.Outlined.CalendarMonth,
                title = "Schedule & Relax",
                body = "Plan your week ahead. We handle the\nshopping, cooking, and delivery.",
                button = "Get Started"
            )
        )
    }
    var pageIndex by remember { mutableIntStateOf(0) }
    val page = pages[pageIndex]
    val isLast = pageIndex == pages.lastIndex

    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(page.background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.44f))
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Transparent,
                        0.42f to Color.Black.copy(alpha = 0.08f),
                        1f to Color.Black.copy(alpha = 0.74f)
                    )
                )
        )

        Column(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp, vertical = 28.dp)
        ) {
            Box(
                Modifier
                    .padding(top = 92.dp)
                    .size(72.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Accent),
                contentAlignment = Alignment.Center
            ) {
                Icon(page.icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(38.dp))
            }

            Spacer(Modifier.weight(1f))

            Text(
                text = page.title,
                color = Color.White,
                fontSize = 38.sp,
                lineHeight = 46.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = page.body,
                color = Color.White.copy(alpha = 0.82f),
                fontSize = 22.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 24.dp)
            )

            Row(
                modifier = Modifier.padding(top = 56.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                pages.indices.forEach { index ->
                    val active = index == pageIndex
                    Box(
                        Modifier
                            .height(8.dp)
                            .width(if (active) 44.dp else 8.dp)
                            .clip(CircleShape)
                            .background(if (active) Accent else Color.White.copy(alpha = 0.82f))
                    )
                }
            }

            PrimaryButton(
                text = page.button,
                onClick = {
                    if (isLast) {
                        onDone()
                    } else {
                        pageIndex += 1
                    }
                },
                modifier = Modifier.fillMaxWidth().padding(top = 36.dp)
            )

            if (!isLast) {
                Text(
                    text = "Skip",
                    color = Accent,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 26.dp, bottom = 8.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .clickable(onClick = onDone)
                        .padding(horizontal = 18.dp, vertical = 8.dp)
                )
            } else {
                Spacer(Modifier.height(60.dp))
            }
        }
    }
}
