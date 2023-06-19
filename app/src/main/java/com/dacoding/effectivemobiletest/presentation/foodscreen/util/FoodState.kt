package com.dacoding.effectivemobiletest.presentation.foodscreen.util

import com.dacoding.effectivemobiletest.domain.model.Food
import com.dacoding.effectivemobiletest.domain.model.FoodData

data class FoodState(
    val foodData: FoodData? = null,
    val selectedFood: Food? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
    val tags: List<FoodTag> = listOf(
        FoodTag.AllMenu,
        FoodTag.Salad,
        FoodTag.WithRice,
        FoodTag.WithFish
    ),
    val selectedTags: List<FoodTag> = listOf(FoodTag.AllMenu),
)

