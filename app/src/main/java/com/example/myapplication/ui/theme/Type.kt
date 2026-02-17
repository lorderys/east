package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.east.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
    )

private val manRopeGF = GoogleFont("Manrope")

private val cormorantGF = GoogleFont("Cormorant Garamond")

val manRope = FontFamily(
    Font(googleFont = manRopeGF, fontProvider = provider)
)

val cormorant = FontFamily(
    Font(googleFont = cormorantGF, fontProvider = provider)
)

val Typography = Typography(

    bodyMedium = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp
    ),
    bodySmall = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 22.sp
    ),
    labelSmall = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    titleMedium = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 32.sp
    ),
    titleLarge = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 26.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 18.sp,
        lineHeight = 22.sp
    )

)