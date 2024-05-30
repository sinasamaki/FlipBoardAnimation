package com.sinasamaki.flipboardanimation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.sinasamaki.flipboardanimation.R


val league = FontFamily(
    Font(resId = R.font.league, weight = FontWeight.Normal),
    Font(resId = R.font.league_bold, weight = FontWeight.Bold)
)

val playfair = FontFamily(
    Font(resId = R.font.playfair, weight = FontWeight.Normal)
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = league,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = playfair,
        fontSize = 32.sp,
    ),
    labelSmall = TextStyle(
        fontFamily = league,
        fontSize = 10.sp,
        fontWeight = FontWeight.Bold,
    ),
)