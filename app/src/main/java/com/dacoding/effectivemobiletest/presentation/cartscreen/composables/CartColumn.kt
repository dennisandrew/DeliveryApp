package com.dacoding.effectivemobiletest.presentation.cartscreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartEvent
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.CartState
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun CartColumn(
    viewModel: ProductViewModel,
    modifier: Modifier = Modifier,
    state: State<CartState>
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        state.value.cartFood.let { data ->
            LazyColumn(
                modifier = modifier.weight(1f),
                content = {
                    items(data) { foodInfo ->
                        CartItem(
                            item = foodInfo,
                            addClick = {
                                viewModel.onCartEvent(cartEvent = CartEvent.CartPlus(foodInfo))
                            },
                            minusClick = {
                                viewModel.onCartEvent(cartEvent = CartEvent.CartMinus(foodInfo))
                            },
                            removeClick = {
                                viewModel.onCartEvent(
                                    cartEvent = CartEvent.CartPositionRemove(foodInfo)
                                )
                            }
                        )
                    }
                },
                verticalArrangement = Arrangement.spacedBy(16.dp)
            )
            Button(
                modifier = Modifier
                    .padding(top = 22.dp)
                    .size(width = 343.dp, height = 48.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3364E0)
                ),
                onClick = {
                    viewModel.onCartEvent(cartEvent = CartEvent.OrderConfirmed)
                },
            ) {
                Text(
                    text = "Оплатить ${state.value.sum} ₽"
                )
            }
        }
    }
}




