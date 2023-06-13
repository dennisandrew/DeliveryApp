package com.dacoding.effectivemobiletest.data.repository

import com.dacoding.effectivemobiletest.R
import com.dacoding.effectivemobiletest.data.mappers.toCategoryData
import com.dacoding.effectivemobiletest.data.remote.CategoryApi
import com.dacoding.effectivemobiletest.domain.model.CategoryData
import com.dacoding.effectivemobiletest.domain.repository.CategoryRepository
import com.dacoding.effectivemobiletest.domain.util.Resource
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: CategoryApi
) : CategoryRepository {
    override suspend fun getCategoryData(): Resource<CategoryData> {
        return try {
            Resource.Success(
                data = api.getCategoryData().toCategoryData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: R.string.unknown_error.toString())
        }

    }
}