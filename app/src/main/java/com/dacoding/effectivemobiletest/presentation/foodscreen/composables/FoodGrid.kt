package com.dacoding.effectivemobiletest.presentation.foodscreen.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodEvent
import com.dacoding.effectivemobiletest.presentation.foodscreen.util.FoodState
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun FoodGrid(
    viewModel: ProductViewModel,
    state: State<FoodState>
) {
    val openDialog = remember { mutableStateOf(false) }
    state.value.foodData?.dishes?.let { data ->
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            columns = GridCells.Fixed(3),
            content = {
                items(
                    data.filter { foodData ->
                        state.value.selectedTags.any { tag ->
                            foodData.tegs.contains(tag.name)
                        }
                    }) { foodData ->
                    Column(
                        modifier = Modifier
                            .padding(bottom = 14.dp)
                            .clickable {
                                viewModel.onFoodEvent(foodEvent = FoodEvent.ClickOnItem(foodData))
                                openDialog.value = true
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Card(
                            modifier = Modifier
                                .size(109.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFF8F7F5),
                            ),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            AsyncImage(
                                modifier = Modifier
                                    .size(95.dp)
                                    .padding(start = 19.dp, top = 25.dp),
                                model = foodData.image_url,
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Box(
                            modifier = Modifier.width(109.dp),
                            contentAlignment = Alignment.TopStart
                        ) {
                            Text(
                                text = foodData.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight(400),
                                color = Color.Black,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                            )
                        }
                    }
                }
            }
        )
        if (openDialog.value)
            FoodDialog(
                openDialog = openDialog,
                viewModel = viewModel,
                state = state
            )
    }
}