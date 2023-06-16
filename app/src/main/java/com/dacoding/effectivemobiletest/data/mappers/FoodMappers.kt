package com.dacoding.effectivemobiletest.data.mappers

import com.dacoding.effectivemobiletest.data.remote.dto.FoodDataDto
import com.dacoding.effectivemobiletest.data.remote.dto.FoodDto
import com.dacoding.effectivemobiletest.domain.model.Food
import com.dacoding.effectivemobiletest.domain.model.FoodData

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