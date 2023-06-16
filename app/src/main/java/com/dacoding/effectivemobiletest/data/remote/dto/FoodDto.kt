package com.dacoding.effectivemobiletest.data.remote.dto

import com.squareup.moshi.Json

data class FoodDto(
    @field:Json(name = "description")
    val description: String,
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "image_url")
    val image_url: String,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "price")
    val price: Int,
    @field:Json(name = "tegs")
    val tegs: List<String>,
    @field:Json(name = "weight")
    val weight: Int
)
