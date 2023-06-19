package com.dacoding.effectivemobiletest.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dacoding.effectivemobiletest.presentation.cartscreen.CartScreen
import com.dacoding.effectivemobiletest.presentation.foodscreen.FoodScreen
import com.dacoding.effectivemobiletest.presentation.homescreen.MainScreen
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainViewModel
import com.dacoding.effectivemobiletest.presentation.util.ProductViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    startDestination: String = "main",
    mainViewModel: MainViewModel,
    foodToCartSharedViewModel: ProductViewModel,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(route = BottomBarScreen.Main.route) {
            MainScreen(viewModel = mainViewModel, navController = navHostController)
        }
        composable(
            route = CategoryItemScreen.Food.route,
            arguments = listOf(navArgument("category_name") {
                type = NavType.StringType
            }
            )
        ) {
            Log.d("ARGS", it.arguments?.getString("category_name").toString())
            FoodScreen(
                viewModel = foodToCartSharedViewModel,
                navController = navHostController,
                backStackEntry = it
            )
        }

        composable(route = BottomBarScreen.Cart.route) {
            CartScreen(viewModel = foodToCartSharedViewModel)
        }
    }
}