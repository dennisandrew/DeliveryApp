package com.dacoding.effectivemobiletest.presentation.homescreen.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.dacoding.effectivemobiletest.domain.model.Category

@Composable
fun CardItem(
    categoryData: Category
) {
    Card(
        modifier = Modifier
            .height(148.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = categoryData.image_url,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .width(155.dp)
                    .padding(top = 12.dp, start = 16.dp),

                contentAlignment = Alignment.TopStart
            ) {
                Text(
                    text = categoryData.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Black
                )
            }
        }
    }
}