package com.dacoding.effectivemobiletest.data.remote

import com.dacoding.effectivemobiletest.data.remote.dto.CategoryDataDto
import retrofit2.http.GET

interface CategoryApi {

    @GET(
        "v3/058729bd-1402-4578-88de-265481fd7d54"
    )

    suspend fun getCategoryData(): CategoryDataDto
}