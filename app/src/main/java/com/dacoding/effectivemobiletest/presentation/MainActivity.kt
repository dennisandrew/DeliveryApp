package com.dacoding.effectivemobiletest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainViewModel
import com.dacoding.effectivemobiletest.presentation.navigation.AppNavHost
import com.dacoding.effectivemobiletest.presentation.navigation.BottomBar
import com.dacoding.effectivemobiletest.presentation.ui.theme.EffectiveMobileTestTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.loadCategoryData()

        setContent {
            EffectiveMobileTestTheme {
                navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = { BottomBar(navController = navController) }
                    ) {
                        AppNavHost(navHostController = navController, mainViewModel = mainViewModel)
                    }

                }
            }
        }
    }
}