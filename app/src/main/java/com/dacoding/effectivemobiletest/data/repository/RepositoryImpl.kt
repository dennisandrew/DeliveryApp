package com.dacoding.effectivemobiletest.data.repository

import com.dacoding.effectivemobiletest.R
import com.dacoding.effectivemobiletest.data.mappers.toCategoryData
import com.dacoding.effectivemobiletest.data.mappers.toFoodData
import com.dacoding.effectivemobiletest.data.remote.CategoryApi
import com.dacoding.effectivemobiletest.data.remote.FoodApi
import com.dacoding.effectivemobiletest.domain.model.CategoryData
import com.dacoding.effectivemobiletest.domain.model.FoodData
import com.dacoding.effectivemobiletest.domain.repository.Repository
import com.dacoding.effectivemobiletest.domain.util.Resource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val categoryApi: CategoryApi,
    private val foodApi: FoodApi
) : Repository {
    override suspend fun getCategoryData(): Resource<CategoryData> {
        return try {
            Resource.Success(
                data = categoryApi.getCategoryData().toCategoryData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: R.string.unknown_error.toString())
        }

    }

    override suspend fun getFoodData(): Resource<FoodData> {
        return try {
            Resource.Success(
                data = foodApi.getFoodData().toFoodData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: R.string.unknown_error.toString())
        }
    }
}