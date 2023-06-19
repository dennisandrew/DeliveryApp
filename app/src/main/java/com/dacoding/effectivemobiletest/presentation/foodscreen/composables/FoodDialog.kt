package com.dacoding.effectivemobiletest.presentation.foodscreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dacoding.effectivemobiletest.R
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodState
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun FoodDialog(
    viewModel: ProductViewModel,
    state: State<FoodState>,
    openDialog: MutableState<Boolean>,
) {

    if (state.value.error == null) {
        AlertDialog(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp)),
            onDismissRequest = {
                openDialog.value = false
            },
            containerColor = Color.White,
            title = {
                state.value.selectedFood?.let { food ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF8F7F5)
                        ),
                    ) {
                        Box {
                            AsyncImage(
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(start = 80.dp, top = 15.dp),
                                model = food.image_url,
                                contentDescription = null
                            )
                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.TopEnd
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(top = 8.dp, end = 8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color.White)
                                            .clickable {
                                                // Nothing
                                            },
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_favorite),
                                            contentDescription = null,
                                            tint = Color.Black
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(Color.White)
                                            .clickable {
                                                openDialog.value = false
                                            },
                                        contentAlignment = Alignment.Center,
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.ic_close),
                                            contentDescription = null,
                                            tint = Color.Black
                                        )
                                    }

                                }
                            }

                        }

                    }
                }
            },
            text = {
                Column {
                    Text(
                        text = state.value.selectedFood?.name ?: "",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight(500),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Text(
                            text = "${state.value.selectedFood?.price} ₽",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color.Black,
                            lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                        )
                        Text(
                            modifier = Modifier
                                .alpha(0.5f),
                            text = " · ${state.value.selectedFood?.weight}г",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color.Black,
                            lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        modifier = Modifier
                            .alpha(0.65f),
                        text = state.value.selectedFood?.description ?: "",
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        color = Color.Black,
                        lineHeight = TextUnit(value = 15.4f, type = TextUnitType.Sp),
                        overflow = TextOverflow.Ellipsis
                    )
                }
            },

            confirmButton = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {
                            viewModel.onFoodEvent(foodEvent = FoodEvent.AddToCart(state.value.selectedFood!!))
                            openDialog.value = false
                        }
                    ) {
                        Text(text = "Добавить в корзину")
                    }
                }

            }
        )
    }
}



