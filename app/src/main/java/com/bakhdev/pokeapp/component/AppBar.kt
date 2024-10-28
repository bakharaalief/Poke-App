package com.bakhdev.pokeapp.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bakhdev.core_ui.component.text.CustomText
import com.bakhdev.core_ui.theme.PokeAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar() {
    val topBorderColor = MaterialTheme.colorScheme.onPrimary

    CenterAlignedTopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = topBorderColor,
                    start = androidx.compose.ui.geometry.Offset(0f, size.height),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width,
                        size.height
                    ),
                    strokeWidth = 5.dp.toPx()
                )
            },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = {
            CustomText(
                text = "PokeApp",
                color = MaterialTheme.colorScheme.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
        },
    )
}

@Composable
@Preview
fun PreviewAppBar() {
    PokeAppTheme(
        dynamicColor = false
    ) {
        AppBar()
    }
}