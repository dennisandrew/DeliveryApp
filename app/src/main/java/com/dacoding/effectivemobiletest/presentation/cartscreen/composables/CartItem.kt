package com.dacoding.effectivemobiletest.presentation.cartscreen.composables

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dacoding.effectivemobiletest.R
import com.dacoding.effectivemobiletest.presentation.cartscreen.util.Product

@Composable
fun CartItem(
    item: Product,
    addClick: (item: Product) -> Unit,
    minusClick: (item: Product) -> Unit,
    removeClick: (item: Product) -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.size(62.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFF8F7F5)
                    )
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(55.dp)
                            .padding(start = 10.dp, top = 10.dp),
                        model = item.food.image_url,
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
                Column {
                    Text(
                        text = item.food.name,
                        fontWeight = FontWeight(400),
                        fontSize = 14.sp,
                        color = Color.Black,
                        lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                    )
                    Row {
                        Text(
                            text = "${item.food.price} ₽",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .alpha(0.5f),
                            text = " · ${item.food.weight}г",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight(400),
                            fontSize = 14.sp,
                            color = Color.Black,
                            lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .size(width = 100.dp, height = 32.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFEFEEEC)),
            contentAlignment = Alignment.Center,
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.clickable {
                        minusClick(item)
                        if (item.count <= 0) {
                            removeClick(item)
                        }
                        Log.d(
                            "CART_ITEM",
                            "This position food count is: ${item.count}"
                        )
                    },
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = null,
                    tint = Color.Black
                )
                Box(
                    modifier = Modifier.fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = item.count.toString(),
                        fontWeight = FontWeight(500),
                        fontSize = 14.sp,
                        color = Color.Black,
                        lineHeight = TextUnit(value = 14.7f, type = TextUnitType.Sp)
                    )
                }
                Icon(
                    modifier = Modifier.clickable {
                        addClick(item)

                        Log.d(
                            "CART_ITEM",
                            "This position food count is: ${item.count}"
                        )
                    },
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}