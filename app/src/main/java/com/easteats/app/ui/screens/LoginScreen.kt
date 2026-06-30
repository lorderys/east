package com.easteats.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.easteats.app.R
import com.easteats.app.ui.components.PrimaryButton
import com.easteats.app.ui.components.SecondaryButton
import com.easteats.app.ui.theme.Accent
import com.easteats.app.ui.theme.AccentDeep
import com.easteats.app.ui.theme.Ink
import com.easteats.app.ui.theme.Muted
import com.easteats.app.ui.theme.Panel
import com.easteats.app.ui.theme.Stroke
import com.easteats.app.ui.theme.TextPrimary

private const val DemoEmail = "email@easteats.app"
private const val DemoPassword = "********"

@Composable
fun LoginScreen(onLogin: () -> Unit) {
    var email by remember { mutableStateOf(DemoEmail) }
    var password by remember { mutableStateOf(DemoPassword) }
    var passwordVisible by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }

    Box(Modifier.fillMaxSize().background(Ink)) {
        Image(
            painter = painterResource(R.drawable.background_03),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        0f to Color.Black.copy(alpha = 0.38f),
                        0.36f to Ink.copy(alpha = 0.82f),
                        1f to Ink
                    )
                )
        )

        Column(
            Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 22.dp, vertical = 26.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                Modifier
                    .size(66.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Accent),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Outlined.Restaurant, contentDescription = null, tint = Color.White, modifier = Modifier.size(34.dp))
            }
            Text(
                text = "Welcome to EastEats",
                color = TextPrimary,
                fontSize = 34.sp,
                lineHeight = 40.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 26.dp)
            )
            Text(
                text = "Sign in to explore curated meals, weekly plans, and fast delivery.",
                color = TextPrimary.copy(alpha = 0.72f),
                fontSize = 16.sp,
                lineHeight = 24.sp,
                modifier = Modifier.padding(top = 12.dp, bottom = 28.dp)
            )

            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(22.dp))
                    .background(Panel.copy(alpha = 0.94f))
                    .border(1.dp, Color.White.copy(alpha = 0.07f), RoundedCornerShape(22.dp))
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                LoginField(
                    value = email,
                    onValueChange = {
                        email = it
                        error = null
                    },
                    label = "Email",
                    icon = Icons.Outlined.AlternateEmail,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next)
                )
                LoginField(
                    value = password,
                    onValueChange = {
                        password = it
                        error = null
                    },
                    label = "Password",
                    icon = Icons.Outlined.Lock,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                if (passwordVisible) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                                contentDescription = null,
                                tint = Muted
                            )
                        }
                    }
                )

                error?.let {
                    Text(
                        text = it,
                        color = Accent,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                PrimaryButton(
                    text = "Log In",
                    onClick = {
                        if (email.trim() == DemoEmail && password == DemoPassword) {
                            onLogin()
                        } else {
                            error = "Use $DemoEmail and $DemoPassword while auth is in test mode."
                        }
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 4.dp)
                )
//                SecondaryButton(
//                    text = "Continue with demo",
//                    onClick = onLogin,
//                    modifier = Modifier.fillMaxWidth(),
//                    light = true
//                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(Modifier.size(8.dp).clip(CircleShape).background(Accent))
                Text(
                    text = "Fresh meals, planned around your day",
                    color = TextPrimary.copy(alpha = 0.68f),
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Composable
private fun LoginField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        trailingIcon = trailingIcon,
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = TextPrimary,
            unfocusedTextColor = TextPrimary,
            focusedBorderColor = Accent,
            unfocusedBorderColor = Stroke,
            focusedLabelColor = Accent,
            unfocusedLabelColor = Muted,
            cursorColor = Accent,
            focusedLeadingIconColor = Accent,
            unfocusedLeadingIconColor = Muted,
            focusedContainerColor = AccentDeep.copy(alpha = 0.32f),
            unfocusedContainerColor = Color(0xFF101115)
        ),
        modifier = modifier.fillMaxWidth()
    )
}
