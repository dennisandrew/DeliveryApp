package com.dacoding.effectivemobiletest.presentation.foodscreen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.dacoding.effectivemobiletest.R
import com.dacoding.effectivemobiletest.presentation.navigation.BottomBarScreen

@Composable
fun FoodTopBar(
    navBackStackEntry: NavBackStackEntry,
    navController: NavController
) {
    val categoryName = navBackStackEntry.arguments?.getString("category_name").toString()
    val text = categoryName.removePrefix("{category_name}")
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    navController.navigate(BottomBarScreen.Main.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                },
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = null,
            tint = Color.Black
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight(500),
            color = Color.Black
        )
        Image(
            modifier = Modifier.size(44.dp),
            painter = painterResource(id = R.drawable.user_photo),
            contentDescription = null
        )
    }
}
