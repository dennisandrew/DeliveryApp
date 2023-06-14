package com.dacoding.effectivemobiletest.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomBar(
    navController: NavHostController,

    ) {
    val screens = listOf(
        BottomBarScreen.Main,
        BottomBarScreen.Search,
        BottomBarScreen.Cart,
        BottomBarScreen.Account
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomAppBar(
        modifier = Modifier.height(88.dp),
        containerColor = Color(0xFFFFFFFF)
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        colors = NavigationBarItemDefaults.colors(
            indicatorColor = Color(0xFFFFFFFF),
            selectedIconColor = Color(0xFF3364E0),
            selectedTextColor = Color(0xFF3364E0),
            unselectedIconColor = Color(0xFFA5A9B2),
            unselectedTextColor = Color(0xFFA5A9B2)
        ),
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = null)
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            if (screen.route == "main" || screen.route == "cart")
                navController.navigate(screen.route)
        }
    )
}