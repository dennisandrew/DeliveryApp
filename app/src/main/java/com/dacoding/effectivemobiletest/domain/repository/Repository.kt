package com.dacoding.effectivemobiletest.domain.repository

import com.dacoding.effectivemobiletest.domain.model.CategoryData
import com.dacoding.effectivemobiletest.domain.model.FoodData
import com.dacoding.effectivemobiletest.domain.util.Resource

interface Repository {
    suspend fun getCategoryData(): Resource<CategoryData>
    suspend fun getFoodData(): Resource<FoodData>
}