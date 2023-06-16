package com.dacoding.effectivemobiletest.presentation.foodscreen.util

sealed class FoodEvent {
    object SelectTag : FoodEvent()
    object UnselectTag : FoodEvent()
}


