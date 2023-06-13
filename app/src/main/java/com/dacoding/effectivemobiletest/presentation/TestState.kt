package com.dacoding.effectivemobiletest.presentation

import com.dacoding.effectivemobiletest.domain.model.CategoryData

data class TestState(
    val categoryData: CategoryData? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
//    val isRefreshing: Boolean = false,
)
