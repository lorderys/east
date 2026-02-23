package com.example.easteats.ui.presentation.screens.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.east.R

data class OnboardingPageInfo (
    val icon: Int,
    val title: String,
    val description: String,
    val bgImage: Painter,
    val buttonText: String
)

@Composable
fun OnboardingFlow() {
    val pages = listOf(
        OnboardingPageInfo(
            icon = R.drawable.ic_chefhat,
            title = "Delicious meals, delivered instantly.",
            description = "Chef-curated menus from top kitchens directly  your door",
            bgImage = painterResource(id = R.drawable.onboardingbg),
            buttonText = "Next"

        ),
        OnboardingPageInfo(
            icon = R.drawable.ic_ai,
            title = "AI-Powered Meal Planning",
            description = "Personalized weekly plans in seconds based on your goals and budget.",
            bgImage = painterResource(id = R.drawable.onboardingbg1),
            buttonText = "Next"

        ),
        OnboardingPageInfo(
            icon = R.drawable.ic_calendar,
            title = "Schedule your meal & Relax",
            description = "Plan your week ahead. We handle the shopping, cooking, and delivery.",
            bgImage = painterResource(id = R.drawable.onboardingbg2),
            buttonText = "Get Started"

        )
    )
}


@Composable
fun OnboardingPage(
    content: OnboardingPageInfo,
    modifier: Modifier
) {
        Box(
            modifier
                .fillMaxSize()
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = content.bgImage,
                contentDescription = content.title,
                modifier = Modifier.matchParentSize()
            )

            Column(
                modifier.padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                OutlinedIconButton(
                    onClick = {  },
                    modifier = Modifier.size(56.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(
                        0.dp,
                        MaterialTheme.colorScheme.primary
                    ),
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Icon(
                        painter = painterResource(id = content.icon),
                        contentDescription = content.title,
                    )
                }

                Spacer(modifier.weight(1f))

                Text(
                    text = content.title,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier.height(20.dp))

                Text(
                    text = content.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier.height(28.dp))

                PageIndicator()

                Button(
                    onClick = {  },
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = content.buttonText)
                }
            }
        }

}

@Composable
fun PageIndicator( ) {
}
