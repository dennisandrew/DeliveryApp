package com.dacoding.domain.repository

import com.dacoding.domain.model.CategoryData
import com.dacoding.domain.model.FoodData
import com.dacoding.domain.util.Resource

interface Repository {
    suspend fun getCategoryData(): Resource<CategoryData>
    suspend fun getFoodData(): Resource<FoodData>
}