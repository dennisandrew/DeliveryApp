package com.dacoding.effectivemobiletest.domain.repository

import com.dacoding.effectivemobiletest.domain.model.CategoryData
import com.dacoding.effectivemobiletest.domain.util.Resource

interface CategoryRepository {
    suspend fun getCategoryData(): Resource<CategoryData>
}