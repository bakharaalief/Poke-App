package com.bakhdev.core_ui.component.loadImage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

@Composable
fun LoadImageLocalGIF(modifier: Modifier, resource: Int, desc: String) {
    AsyncImage(modifier = modifier, model = resource, contentDescription = desc)
}