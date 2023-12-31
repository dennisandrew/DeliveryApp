package com.dacoding.effectivemobiletest.presentation.cartscreen.util

import com.dacoding.domain.model.Food

data class CartState(
    val cartFood: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
    val sum: Int = 0
)

data class Product(
    val food: com.dacoding.domain.model.Food,
    var count: Int
)

