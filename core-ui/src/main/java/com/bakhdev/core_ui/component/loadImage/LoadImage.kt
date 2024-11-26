package com.bakhdev.core_ui.component.loadImage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import coil3.request.ImageRequest
import com.bakhdev.core_ui.R

@Composable
fun LoadImage(modifier: Modifier, url: String, desc: String) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        contentDescription = desc,
        loading = {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(25.dp)
            )
        },
        contentScale = ContentScale.Crop,
        error = {
            painterResource(id = R.drawable.error_outline_24)
        },
        modifier = modifier,
    )
}

