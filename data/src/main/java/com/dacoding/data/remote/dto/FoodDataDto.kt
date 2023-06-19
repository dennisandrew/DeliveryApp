package com.dacoding.data.remote.dto

import com.squareup.moshi.Json

data class FoodDataDto(
    @field:Json(name = "dishes")
    val dishes: List<FoodDto>
)

