package com.dacoding.effectivemobiletest.presentation.homescreen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dacoding.effectivemobiletest.presentation.homescreen.util.MainState

@Composable
fun CardItemsColumn(state: MainState) {
    state.categoryData?.categories?.let { data ->
        LazyColumn(
            content = {
                items(data) { categoryData ->
                    CardItem(categoryData = categoryData)
                }
                      },
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
    }
}