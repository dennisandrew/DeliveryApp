package com.dacoding.effectivemobiletest.presentation.cartscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dacoding.effectivemobiletest.presentation.cartscreen.composables.CartColumn
import com.dacoding.effectivemobiletest.presentation.cartscreen.composables.CartTopBar
import com.dacoding.effectivemobiletest.presentation.util.FoodToCartSharedViewModel

@Composable
fun CartScreen(
    viewModel: FoodToCartSharedViewModel,
    navController: NavHostController
) {
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
        CartTopBar()
        if (viewModel.cartState.cartFood.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = "Корзина пуста",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(200),
                    color = Color.Black
                )
            }
        } else {
//            val cartStringList = mutableListOf<String>()
//                viewModel.cartState.cartFood.forEach {
//                cartStringList.add(it.name)
//            }
//
//
//            Text(text = cartStringList.joinToString(separator = ", "))
            Spacer(modifier = Modifier.height(22.dp))
            CartColumn(state = viewModel.cartState, navController = navController)


        }

    }
}