package com.dacoding.effectivemobiletest.presentation.cartscreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartState

@Composable
fun CartColumn(
    state: CartState,
    navController: NavHostController
) {
    state.cartFood.let { data ->
        LazyColumn(
            content = {
                items(data) { foodInfo ->
                    CartPosition(foodInfo = foodInfo)
                }
            },
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
    }
}