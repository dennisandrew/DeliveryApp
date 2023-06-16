package com.dacoding.effectivemobiletest.presentation.navigation

sealed class CategoryItemScreen(
    val route: String
) {
    object Food : CategoryItemScreen(
        route = "food/{category_name}"
    )
}
