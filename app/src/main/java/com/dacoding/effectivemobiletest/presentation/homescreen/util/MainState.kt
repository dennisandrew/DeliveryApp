package com.dacoding.effectivemobiletest.presentation.homescreen.util

import com.dacoding.domain.model.CategoryData

data class MainState(
    val categoryData: com.dacoding.domain.model.CategoryData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val isRefreshing: Boolean = false,
)
