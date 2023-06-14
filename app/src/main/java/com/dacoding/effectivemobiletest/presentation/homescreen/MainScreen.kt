package com.dacoding.effectivemobiletest.presentation.homescreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dacoding.effectivemobiletest.presentation.homescreen.composables.CardItemsColumn
import com.dacoding.effectivemobiletest.presentation.homescreen.composables.TopItem
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
//    val isRefreshing = viewModel.state.isRefreshing
//     Swipe refresh state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 24.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 88.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopItem()
        Spacer(modifier = Modifier.height(14.dp))
        CardItemsColumn(state = viewModel.state)
    }
}
