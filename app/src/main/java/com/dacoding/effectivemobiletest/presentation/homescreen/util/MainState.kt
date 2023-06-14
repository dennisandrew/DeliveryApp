package com.dacoding.effectivemobiletest.presentation.homescreen.util

import com.dacoding.effectivemobiletest.domain.model.CategoryData

data class MainState(
    val categoryData: CategoryData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)
