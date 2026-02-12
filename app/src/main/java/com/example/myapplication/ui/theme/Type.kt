package com.example.myapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

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
    bodyLarge = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = manRope,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = cormorant,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

)