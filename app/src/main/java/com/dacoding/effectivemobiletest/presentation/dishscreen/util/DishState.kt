package com.dacoding.effectivemobiletest.presentation.dishscreen.util

import com.dacoding.effectivemobiletest.domain.model.FoodData

data class DishState(
    val foodData: FoodData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)

