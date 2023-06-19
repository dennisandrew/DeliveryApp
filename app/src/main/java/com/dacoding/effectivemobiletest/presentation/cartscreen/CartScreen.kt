package com.dacoding.effectivemobiletest.presentation.cartscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.effectivemobiletest.presentation.cartscreen.composables.CartColumn
import com.dacoding.effectivemobiletest.presentation.cartscreen.composables.CartTopBar
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun CartScreen(
    viewModel: ProductViewModel
) {
    val state = viewModel.toConsumableCartState().collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 88.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CartTopBar(modifier = Modifier.padding(bottom = 22.dp))
        if (state.value.cartFood.isEmpty()) {
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
            CartColumn(
                viewModel = viewModel,
                state = state
            )
        }
    }
}



