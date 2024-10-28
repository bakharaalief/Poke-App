package com.bakhdev.core_ui.component.loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bakhdev.core_ui.R
import com.bakhdev.core_ui.component.loadImage.LoadImageLocalGIF
import com.bakhdev.core_ui.component.text.CustomText

@Composable
fun LoadingPage() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LoadImageLocalGIF(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            resource = R.raw.pikachu_running,
            desc = "Loading",
        )

        Spacer(modifier = Modifier.height(25.dp))

        CustomText(
            modifier = Modifier.fillMaxWidth(),
            text = "Loading",
            fontWeight = FontWeight.Normal,
            fontSize = 30.sp
        )
    }
}

@Composable
@Preview
fun LoadingPagePreview() {
    LoadingPage()
}