package com.dacoding.effectivemobiletest.presentation.foodscreen.util

sealed class FoodTag(
    val id: Int,
    val name: String
) {
    object AllMenu : FoodTag(
        id = 0,
        name = "Все меню"
    )

    object Salad : FoodTag(
        id = 1,
        name = "Салаты"
    )

    object WithRice : FoodTag(
        id = 2,
        name = "С рисом"
    )

    object WithFish : FoodTag(
        id = 3,
        name = "С рыбой"
    )
}
