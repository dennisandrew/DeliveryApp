package com.dacoding.effectivemobiletest.presentation.navigation

import androidx.annotation.DrawableRes
import com.dacoding.effectivemobiletest.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object Main : BottomBarScreen(
        route = "main",
        title = "Главная",
        icon = R.drawable.ic_main
    )
    object Search : BottomBarScreen(
        route = "search",
        title = "Поиск",
        icon = R.drawable.ic_search
    )
    object Cart : BottomBarScreen(
        route = "cart",
        title = "Корзина",
        icon = R.drawable.ic_cart
    )
    object Account : BottomBarScreen(
        route = "account",
        title = "Аккаунт",
        icon = R.drawable.ic_account
    )
}
