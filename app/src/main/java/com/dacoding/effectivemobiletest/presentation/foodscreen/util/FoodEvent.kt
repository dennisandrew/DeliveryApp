package com.dacoding.effectivemobiletest.presentation.foodscreen.util

import com.dacoding.effectivemobiletest.domain.model.Food

sealed class FoodEvent {
    data class SelectTag(val tag: FoodTag) : FoodEvent()
    data class UnselectTag(val tag: FoodTag) : FoodEvent()
    data class ClickOnItem(val food: Food) : FoodEvent()
    data class AddToCart(val food: Food) : FoodEvent()
}


