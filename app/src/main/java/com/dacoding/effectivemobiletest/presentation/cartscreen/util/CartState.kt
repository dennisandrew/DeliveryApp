package com.dacoding.effectivemobiletest.presentation.cartscreen.util

import com.dacoding.effectivemobiletest.domain.model.Food

data class CartState(
    val cartFood: MutableList<Food> = ArrayList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false
)

