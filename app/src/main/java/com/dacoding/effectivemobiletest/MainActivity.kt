package com.dacoding.effectivemobiletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.dacoding.effectivemobiletest.presentation.TestViewModel
import com.dacoding.effectivemobiletest.presentation.ui.theme.EffectiveMobileTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val testViewModel: TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testViewModel.loadCategoryData()

        setContent {
            EffectiveMobileTestTheme {

            }
        }
    }
}