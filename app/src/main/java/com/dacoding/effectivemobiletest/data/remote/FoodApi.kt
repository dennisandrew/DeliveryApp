package com.dacoding.effectivemobiletest.data.remote

import com.dacoding.effectivemobiletest.data.remote.dto.FoodDataDto
import retrofit2.http.GET

interface FoodApi {

    @GET(
        "v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b"
    )

    suspend fun getFoodData(): FoodDataDto
}