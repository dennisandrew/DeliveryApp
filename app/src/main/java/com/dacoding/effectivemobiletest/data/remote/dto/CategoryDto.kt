package com.dacoding.effectivemobiletest.data.remote.dto

import com.squareup.moshi.Json

data class CategoryDto(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "image_url")
    val image_url: String
)
