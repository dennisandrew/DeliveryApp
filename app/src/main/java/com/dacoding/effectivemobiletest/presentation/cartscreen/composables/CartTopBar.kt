package com.dacoding.effectivemobiletest.presentation.cartscreen.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dacoding.effectivemobiletest.R
import java.text.SimpleDateFormat
import java.util.Calendar

@Composable
fun CartTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box {
            Row {
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 4.dp),
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(4.dp))
                Column {
                    Text(
                        text = "Санкт-Петербург",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(500),
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.alpha(0.5f),
                        text = getCurrentDate(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight(400),
                        color = Color.Black
                    )
                }
            }
        }
        Image(
            modifier = Modifier.size(44.dp),
            painter = painterResource(id = R.drawable.user_photo),
            contentDescription = null
        )

    }
}

@SuppressLint("SimpleDateFormat")
fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val dayFormat = SimpleDateFormat("dd")
    val monthFormat = SimpleDateFormat("MMMM")
    val yearFormat = SimpleDateFormat("yyyy")
    val day = dayFormat.format(calendar.time)
    val month = monthFormat.format(calendar.time)
    val year = yearFormat.format(calendar.time)

    return "$day ${month.replaceFirstChar { it.uppercase() }}, $year"
}
