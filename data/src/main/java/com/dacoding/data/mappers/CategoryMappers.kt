package com.dacoding.data.mappers

import com.dacoding.data.remote.dto.CategoryDataDto
import com.dacoding.data.remote.dto.CategoryDto
import com.dacoding.domain.model.Category
import com.dacoding.domain.model.CategoryData

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        image_url = image_url
    )
}

fun CategoryDataDto.toCategoryData(): CategoryData {
    return CategoryData(
        categories = categories.map { it.toCategory() }
    )
}

