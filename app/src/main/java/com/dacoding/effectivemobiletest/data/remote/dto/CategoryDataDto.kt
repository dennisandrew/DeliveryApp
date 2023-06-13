package com.dacoding.effectivemobiletest.data.remote.dto

import com.squareup.moshi.Json

data class CategoryDataDto(
    @field:Json(name = "сategories")
    val categories: List<CategoryDto>
)


