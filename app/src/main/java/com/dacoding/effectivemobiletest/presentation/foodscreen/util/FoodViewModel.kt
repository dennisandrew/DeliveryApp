package com.dacoding.effectivemobiletest.presentation.foodscreen.util

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dacoding.effectivemobiletest.domain.repository.Repository
import com.dacoding.effectivemobiletest.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    var state by mutableStateOf(FoodState())

    val selectedTags = mutableStateListOf<FoodTag>(FoodTag.AllMenu)

    fun onEvent(foodEvent: FoodEvent) {
        when (foodEvent) {
            is FoodEvent.SelectTag -> {
                Log.d("FOOD_EVENT", "tag was selected")
                state = state.copy(
                    selectedTags = selectedTags
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${state.selectedTags.size}"
                )
            }

            is FoodEvent.UnselectTag -> {
                Log.d("FOOD_EVENT", "tag was unselected")
                state = state.copy(
                    selectedTags = selectedTags
                )
                Log.d(
                    "FOOD_EVENT",
                    "Current tags state size is: ${state.selectedTags.size}"
                )
            }
        }
    }

    fun loadFoodData() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (
                val result = repository.getFoodData()
            ) {
                is Resource.Success -> {
                    state = state.copy(
                        foodData = result.data,
                        isLoading = false,
                        error = null
                    )
                    Log.d("SUCCESS_LOG", "Result is: ${result.data.toString()}")
                }

                is Resource.Error -> {
                    state = state.copy(
                        foodData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}