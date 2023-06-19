package com.dacoding.data.mappers

import com.dacoding.data.remote.dto.FoodDataDto
import com.dacoding.data.remote.dto.FoodDto
import com.dacoding.domain.model.Food
import com.dacoding.domain.model.FoodData

fun FoodDto.toFood(): Food {
    return Food(
        description = description,
        id = id,
        image_url = image_url,
        name = name,
        price = price,
        tegs = tegs,
        weight = weight
    )
}

fun FoodDataDto.toFoodData(): FoodData {
    return FoodData(
        dishes = dishes.map { it.toFood() }
    )
}