package com.dacoding.effectivemobiletest.presentation.foodscreen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodState
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodTag
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun FoodTags(
    state: State<FoodState>,
    viewModel: ProductViewModel
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(state.value.tags) {
                Box(
                    modifier = Modifier
                        .clickable {
                            val selected = state.value.selectedTags
                            when {
                                selected.contains(it) -> {
                                    if (it != FoodTag.AllMenu) {
                                        viewModel.onFoodEvent(foodEvent = FoodEvent.UnselectTag(it))
                                        if (selected.size <= 1) {
                                            viewModel.onFoodEvent(
                                                foodEvent = FoodEvent.SelectTag(
                                                    FoodTag.AllMenu
                                                )
                                            )
                                        }
                                    }
                                }

                                !selected.contains(it) -> {
                                    if (it != FoodTag.AllMenu) {
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.SelectTag(it)
                                        )
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.UnselectTag(
                                                FoodTag.AllMenu
                                            )
                                        )
                                    } else {
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.SelectTag(
                                                FoodTag.AllMenu
                                            )
                                        )
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.UnselectTag(
                                                FoodTag.Salad
                                            )
                                        )
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.UnselectTag(
                                                FoodTag.WithRice
                                            )
                                        )
                                        viewModel.onFoodEvent(
                                            foodEvent = FoodEvent.UnselectTag(
                                                FoodTag.WithFish
                                            )
                                        )
                                    }

                                }
                            }
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (state.value.selectedTags.contains(it)) {
                                Color(0xFF3364E0)
                            } else {
                                Color(0xFFF8F7F5)
                            }
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                        text = state.value.tags[it.id].name,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        color = if (state.value.selectedTags.contains(it)) {
                            Color.White
                        } else {
                            Color.Black
                        }
                    )
                }
            }
        })
}