package com.example.thirtydays.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.thirtydays.R

val EBGaramond = FontFamily(
    Font(
        resId = R.font.eb_garamond_medium,
        weight = FontWeight.Medium
    ),
    Font(
        resId = R.font.eb_garamond_bold,
        weight = FontWeight.Bold
    ),
    Font(
        resId = R.font.eb_garamond_italic,
        style = FontStyle.Italic
    )
)

val DMSerif = FontFamily(
    Font(
        resId = R.font.dm_serif_display_regular,
        weight = FontWeight.Normal
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = DMSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    displayMedium = TextStyle(
        fontFamily = DMSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 32.sp,
        shadow = Shadow(
            color = Color(0f, 0f, 0f, 0.8f),
            offset = Offset(2f, 2f),
            blurRadius = 80f
        )
    ),
    labelSmall = TextStyle(
        fontFamily = EBGaramond,
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = EBGaramond,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp
    )
)