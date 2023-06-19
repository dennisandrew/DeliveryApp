package com.dacoding.effectivemobiletest.presentation.foodscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodGrid
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodTags
import com.dacoding.effectivemobiletest.presentation.foodscreen.composables.FoodTopBar
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun FoodScreen(
    viewModel: ProductViewModel,
    navController: NavHostController,
    backStackEntry: NavBackStackEntry
) {
    val state = viewModel.toConsumableFoodState().collectAsState()
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
        FoodTags(viewModel = viewModel, state = state)
        Spacer(modifier = Modifier.height(16.dp))
        FoodGrid(viewModel = viewModel, state = state)
    }
}