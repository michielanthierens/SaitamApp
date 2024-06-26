package be.howest.ti.saitamapp.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    ),
    h4 = TextStyle(
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp
    )
)