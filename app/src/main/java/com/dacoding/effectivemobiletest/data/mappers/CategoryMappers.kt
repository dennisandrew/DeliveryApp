package com.dacoding.effectivemobiletest.data.mappers

import com.dacoding.effectivemobiletest.data.remote.dto.CategoryDataDto
import com.dacoding.effectivemobiletest.data.remote.dto.CategoryDto
import com.dacoding.effectivemobiletest.domain.model.Category
import com.dacoding.effectivemobiletest.domain.model.CategoryData

fun CategoryDataDto.toCategoryData(): CategoryData {
    return CategoryData(
        categories = categories
    )
}

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        name = name,
        image_url = image_url
    )
}