package com.dacoding.effectivemobiletest.presentation.foodscreen.util

import com.dacoding.effectivemobiletest.domain.model.FoodData

data class FoodState(
    val foodData: FoodData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
    val selectedTags: List<FoodTag> = listOf(FoodTag.AllMenu)
)