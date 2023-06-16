package com.dacoding.effectivemobiletest.presentation.util

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dacoding.effectivemobiletest.domain.repository.Repository
import com.dacoding.effectivemobiletest.domain.util.Resource
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartState
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodState
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodTag
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodToCartSharedViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    var foodState by mutableStateOf(FoodState())

    var cartState by mutableStateOf(CartState())

    val selectedTags = mutableStateListOf<FoodTag>(FoodTag.AllMenu)

    val selectedFood = mutableStateOf(foodState.food)

    val cartFood = mutableStateOf(cartState.cartFood)

    fun onFoodEvent(foodEvent: FoodEvent) {
        when (foodEvent) {
            is FoodEvent.SelectTag -> {
                Log.d("FOOD_EVENT", "tag was selected")
                foodState = foodState.copy(
                    selectedTags = selectedTags
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${foodState.selectedTags.size}"
                )
            }

            is FoodEvent.UnselectTag -> {
                Log.d("FOOD_EVENT", "tag was unselected")
                foodState = foodState.copy(
                    selectedTags = selectedTags
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${foodState.selectedTags.size}"
                )
            }

            is FoodEvent.ClickOnItem -> {
                foodState = foodState.copy(
                    food = selectedFood.value
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current food state image url is ${foodState.food?.image_url}"
                )
            }

            is FoodEvent.AddToCart -> {
                cartState = cartState.copy(
                    cartFood = cartFood.value,
                )

                Log.d(
                    "FOOD_EVENT",
                    "Current cart size is ${cartState.cartFood.size}"
                )
            }
        }
    }

    fun loadFoodData() {
        viewModelScope.launch {
            foodState = foodState.copy(
                isLoading = true,
                error = null
            )
            when (
                val result = repository.getFoodData()
            ) {
                is Resource.Success -> {
                    foodState = foodState.copy(
                        foodData = result.data,
                        isLoading = false,
                        error = null
                    )
                    Log.d("SUCCESS_LOG", "Result is: ${result.data.toString()}")
                }

                is Resource.Error -> {
                    foodState = foodState.copy(
                        foodData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}