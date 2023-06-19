package com.dacoding.effectivemobiletest.presentation.homescreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainState

@Composable
fun CategoryItemsColumn(state: MainState, navController: NavHostController) {
    state.categoryData?.categories?.let { data ->
        LazyColumn(
            content = {
                items(data) { categoryData ->
                    CategoryItem(categoryData = categoryData, navController = navController)
                }
            },
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
    }
}