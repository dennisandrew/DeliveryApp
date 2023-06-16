package com.dacoding.effectivemobiletest.presentation.homescreen.util

import android.util.Log
import androidx.compose.runtime.getValue
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
class MainViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    var state by mutableStateOf(MainState())

    fun loadCategoryData() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when (
                val result = repository.getCategoryData()
            ) {
                is Resource.Success -> {
                    state = state.copy(
                        categoryData = result.data,
                        isLoading = false,
                        error = null
                    )
                    Log.d("SUCCESS_LOG", "Result is: ${result.data.toString()}")
                }

                is Resource.Error -> {
                    state = state.copy(
                        categoryData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}