package com.dacoding.data.repository

import com.dacoding.data.mappers.toCategoryData
import com.dacoding.data.mappers.toFoodData
import com.dacoding.data.remote.CategoryApi
import com.dacoding.data.remote.FoodApi
import com.dacoding.domain.model.CategoryData
import com.dacoding.domain.model.FoodData
import com.dacoding.domain.repository.Repository
import com.dacoding.domain.util.Resource
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
            Resource.Error(e.message ?: com.dacoding.data.R.string.unknown_error.toString())
        }

    }

    override suspend fun getFoodData(): Resource<FoodData> {
        return try {
            Resource.Success(
                data = foodApi.getFoodData().toFoodData()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: com.dacoding.data.R.string.unknown_error.toString())
        }
    }
}