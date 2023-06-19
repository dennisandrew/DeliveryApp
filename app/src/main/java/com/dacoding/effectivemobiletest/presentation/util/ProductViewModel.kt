package com.dacoding.effectivemobiletest.presentation.util

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dacoding.domain.repository.Repository
import com.dacoding.domain.util.Resource
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartEvent
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartState
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.Product
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: com.dacoding.domain.repository.Repository,
) : ViewModel() {

    private val foodState = MutableStateFlow(FoodState())

    fun toConsumableFoodState() = foodState.asStateFlow()

    private val cartState = MutableStateFlow(CartState())

    fun toConsumableCartState() = cartState.asStateFlow()

    fun onFoodEvent(foodEvent: FoodEvent) {
        when (foodEvent) {
            is FoodEvent.SelectTag -> {
                foodState.value = foodState.value.copy(
                    selectedTags = foodState.value.selectedTags.toMutableList().apply {
                        add(foodEvent.tag)
                    }.toList()
                )
                Log.d(
                    "FOOD_EVENT",
                    "tag was selected"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${foodState.value.selectedTags.size}"
                )
            }

            is FoodEvent.UnselectTag -> {
                foodState.value = foodState.value.copy(
                    selectedTags = foodState.value.selectedTags.toMutableList().apply {
                        remove(foodEvent.tag)
                    }.toList()
                )
                Log.d(
                    "FOOD_EVENT",
                    "tag was unselected"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${foodState.value.selectedTags.size}"
                )
            }

            is FoodEvent.ClickOnItem -> {
                foodState.value = foodState.value.copy(
                    selectedFood = foodEvent.food
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current food state image url is ${foodState.value.selectedFood?.image_url}"
                )
            }

            is FoodEvent.AddToCart -> {
                cartState.value = cartState.value.copy(
                    cartFood = cartState.value.cartFood.toMutableList().apply {
                        add(Product(food = foodEvent.food, 1))
                    }.toList(),
                    sum = cartState.value.sum + foodEvent.food.price
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current cart size is ${cartState.value.cartFood.size}"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current sum is ${cartState.value.sum}"
                )
            }
        }
    }

    fun onCartEvent(cartEvent: CartEvent) {
        when (cartEvent) {
            is CartEvent.CartPlus -> {
                cartState.value = cartState.value.copy(
                    cartFood = cartState.value.cartFood.toMutableList().apply {
                        find { it == cartEvent.position }?.let {
                            it.count += 1
                        } ?: run {
                            cartState.value.cartFood.toMutableList().add(cartEvent.position)
                        }
                    }.toList(),
                    sum = cartState.value.sum + cartEvent.position.food.price
                )

                Log.d(
                    "CART_EVENT",
                    "cart was updated +"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current sum is ${cartState.value.sum}"
                )
            }

            is CartEvent.CartMinus -> {
                cartState.value = cartState.value.copy(
                    cartFood = cartState.value.cartFood.toMutableList().apply {
                        find { it == cartEvent.position }?.let {
                            it.count -= 1
                        } ?: run {
                            cartState.value.cartFood.toMutableList().add(cartEvent.position)
                        }
                    }.toList(),
                    sum = cartState.value.sum - cartEvent.position.food.price
                )

                Log.d(
                    "CART_EVENT",
                    "cart was updated -"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current sum is ${cartState.value.sum}"
                )
            }

            is CartEvent.OrderConfirmed -> {
                cartState.value = cartState.value.copy(
                    cartFood = cartState.value.cartFood.toMutableList().apply {
                        clear()
                    }.toList(),
                    sum = 0
                )
                Log.d(
                    "CART_EVENT",
                    "order was confirmed, current cart positions count is: ${cartState.value.cartFood.size}"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current sum is ${cartState.value.sum}"
                )
            }

            is CartEvent.CartPositionRemove -> {
                cartState.value = cartState.value.copy(
                    cartFood = cartState.value.cartFood.toMutableList().apply {
                        remove(cartEvent.position)
                    }.toList()
                )

                Log.d(
                    "CART_EVENT",
                    "cart position was removed, current cart positions count is: ${cartState.value.cartFood.size}"
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current sum is ${cartState.value.sum}"
                )
            }
        }

    }

    fun loadFoodData() {
        viewModelScope.launch {
            foodState.value = foodState.value.copy(
                isLoading = true,
                error = null
            )
            when (
                val result = repository.getFoodData()
            ) {
                is com.dacoding.domain.util.Resource.Success -> {
                    foodState.value = foodState.value.copy(
                        foodData = result.data,
                        isLoading = false,
                        error = null
                    )
                    Log.d(
                        "SUCCESS_LOG",
                        "Result is: ${result.data.toString()}"
                    )
                }

                is com.dacoding.domain.util.Resource.Error -> {
                    foodState.value = foodState.value.copy(
                        foodData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}