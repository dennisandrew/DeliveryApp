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
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodTag
import com.dacoding.effectivemobiletest.presentation.util.FoodToCartSharedViewModel

@Composable
fun FoodTags(
    viewModel: FoodToCartSharedViewModel,
    tags: List<FoodTag>,
    selectedTags: SnapshotStateList<FoodTag>

) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(tags) {
                Box(
                    modifier = Modifier
                        .clickable {
                            if (!selectedTags.contains(it)) {
                                if (it.name != FoodTag.AllMenu.name) {
                                    selectedTags.add(it)
                                    viewModel.onFoodEvent(foodEvent = FoodEvent.SelectTag)
                                    selectedTags.remove(FoodTag.AllMenu)
                                    viewModel.onFoodEvent(foodEvent = FoodEvent.UnselectTag)
                                }

                            } else {
                                if (it.name != FoodTag.AllMenu.name) {
                                    selectedTags.remove(it)
                                    viewModel.onFoodEvent(foodEvent = FoodEvent.UnselectTag)
                                    if (selectedTags.size == 0) {
                                        selectedTags.add(FoodTag.AllMenu)
                                        viewModel.onFoodEvent(foodEvent = FoodEvent.SelectTag)
                                    }
                                }


                            }
                        }
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            if (selectedTags.contains(it)) {
                                Color(0xFF3364E0)
                            } else {
                                Color(0xFFF8F7F5)
                            }
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
                        text = tags[it.id].name,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        color = if (selectedTags.contains(it)) {
                            Color.White
                        } else {
                            Color.Black
                        }
                    )
                }
            }
        })
}