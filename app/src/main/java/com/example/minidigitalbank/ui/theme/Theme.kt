package com.example.minidigitalbank.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme

private val LightColorScheme = lightColorScheme(
    primary = BankBlue,
    onPrimary = LightSurface,
    primaryContainer = BankBlueSurface,
    onPrimaryContainer = BankBlueDark,
    secondary = NeutralGray500,
    onSecondary = LightSurface,
    secondaryContainer = NeutralGray100,
    onSecondaryContainer = NeutralGray800,
    tertiary = IncomeGreen,
    onTertiary = LightSurface,
    background = LightBackground,
    onBackground = LightOnSurface,
    surface = LightSurface,
    onSurface = LightOnSurface,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = NeutralGray200,
    outlineVariant = NeutralGray100,
    error = ExpenseRed,
    onError = LightSurface,
)

private val DarkColorScheme = darkColorScheme(
    primary = BankBlueLight,
    onPrimary = DarkBackground,
    primaryContainer = BankBlueDark,
    onPrimaryContainer = BankBlueSurface,
    secondary = NeutralGray400,
    onSecondary = DarkBackground,
    secondaryContainer = NeutralGray700,
    onSecondaryContainer = NeutralGray100,
    tertiary = IncomeGreen,
    onTertiary = DarkBackground,
    background = DarkBackground,
    onBackground = DarkOnSurface,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = NeutralGray700,
    outlineVariant = NeutralGray800,
    error = ExpenseRed,
    onError = DarkBackground,
)

@Composable
fun MiniDigitalBankTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}