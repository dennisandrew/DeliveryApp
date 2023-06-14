package com.dacoding.effectivemobiletest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dacoding.effectivemobiletest.presentation.cartscreen.CartScreen
import com.dacoding.effectivemobiletest.presentation.homescreen.MainScreen
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = "main",
    mainViewModel: MainViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = BottomBarScreen.Main.route) {
            MainScreen(viewModel = mainViewModel)
        }
        composable(route = BottomBarScreen.Cart.route) {
            CartScreen()
        }
    }
}