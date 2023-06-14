package com.dacoding.effectivemobiletest.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.dacoding.effectivemobiletest.R

// Set of Material typography styles to start with

private val defaultTypography = Typography()

private val sfFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.sf_pro_display_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.sf_pro_display_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.sf_pro_display_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.sf_pro_display_semibold,
            weight = FontWeight.SemiBold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.sf_pro_display_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.sf_pro_display_regularitalic,
            weight = FontWeight.Normal,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.sf_pro_display_lightitalic,
            weight = FontWeight.Light,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.sf_pro_display_mediumitalic,
            weight = FontWeight.Medium,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.sf_pro_display_semibolditalic,
            weight = FontWeight.SemiBold,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.sf_pro_display_bolditalic,
            weight = FontWeight.Bold,
            style = FontStyle.Italic
        ),

        )
)


val appTypography = Typography(
    headlineLarge = defaultTypography.headlineLarge.copy(
        fontFamily = sfFamily
    ),
    displayLarge = defaultTypography.displayLarge.copy(
        fontFamily = sfFamily
    ),
    displayMedium = defaultTypography.displayMedium.copy(
        fontFamily = sfFamily
    ),
    displaySmall = defaultTypography.displaySmall.copy(
        fontFamily = sfFamily
    ),
    headlineMedium = defaultTypography.headlineMedium.copy(
        fontFamily = sfFamily
    ),
    headlineSmall = defaultTypography.headlineSmall.copy(
        fontFamily = sfFamily
    ),
    titleLarge = defaultTypography.titleLarge.copy(
        fontFamily = sfFamily
    ),
    titleMedium = defaultTypography.titleMedium.copy(
        fontFamily = sfFamily
    ),
    titleSmall = defaultTypography.titleSmall.copy(
        fontFamily = sfFamily
    ),
    bodyLarge = defaultTypography.bodyLarge.copy(
        fontFamily = sfFamily
    ),
    bodyMedium = defaultTypography.bodyMedium.copy(
        fontFamily = sfFamily
    ),
    bodySmall = defaultTypography.bodySmall.copy(
        fontFamily = sfFamily
    ),
    labelLarge = defaultTypography.labelLarge.copy(
        fontFamily = sfFamily
    ),
    labelMedium = defaultTypography.labelMedium.copy(
        fontFamily = sfFamily
    ),
    labelSmall = defaultTypography.labelSmall.copy(
        fontFamily = sfFamily
    )


)