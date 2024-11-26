package com.bakhdev.core_ui.component.loadImage

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun LoadImageLocal(modifier: Modifier, resource: Int, desc: String) {
    Image(
        modifier = modifier,
        painter = painterResource(id = resource),
        contentDescription = desc
    )
}