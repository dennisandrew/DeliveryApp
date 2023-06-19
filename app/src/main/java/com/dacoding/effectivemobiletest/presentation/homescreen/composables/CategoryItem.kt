package com.dacoding.effectivemobiletest.presentation.homescreen.composables

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.dacoding.effectivemobiletest.presentation.navigation.CategoryItemScreen

@Composable
fun CategoryItem(
    categoryData: com.dacoding.domain.model.Category,
    navController: NavHostController,
) {
    val categoryName = categoryData.name
    Card(
        modifier = Modifier
            .height(148.dp)
            .clickable {
                navController.navigate(route = CategoryItemScreen.Food.route + categoryName) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
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
                    color = Color.Black,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}