package com.dacoding.effectivemobiletest.presentation.foodscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodGrid
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodTags
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodTopBar
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodTag
import com.dacoding.effectivemobiletest.presentation.util.FoodToCartSharedViewModel

@Composable
fun FoodScreen(
    viewModel: FoodToCartSharedViewModel,
    navController: NavHostController,
    backStackEntry: NavBackStackEntry
) {
    val tags = listOf(FoodTag.AllMenu, FoodTag.Salad, FoodTag.WithRice, FoodTag.WithFish)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 88.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FoodTopBar(navBackStackEntry = backStackEntry, navController = navController)
        Spacer(modifier = Modifier.height(8.dp))
        FoodTags(tags = tags, viewModel = viewModel, selectedTags = viewModel.selectedTags)
        Spacer(modifier = Modifier.height(16.dp))
        FoodGrid(viewModel = viewModel, selectedFood = viewModel.selectedFood)
    }
}