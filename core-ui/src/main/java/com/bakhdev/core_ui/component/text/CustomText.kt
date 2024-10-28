package com.bakhdev.core_ui.component.text

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bakhdev.core_ui.R

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    textAlign: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onPrimary
) {
    val courierFontFamily = FontFamily(
        Font(R.font.courier_prime_bold, FontWeight.Bold),
        Font(R.font.courier_prime_regular, FontWeight.Normal)
    )

    Text(
        text = text,
        modifier = modifier,
        fontWeight = fontWeight,
        fontFamily = courierFontFamily,
        fontSize = fontSize,
        textAlign = textAlign,
        color = color
    )
}

@Composable
@Preview
fun PreviewCustomFont() {
    val text = "Bulbasaur"

    Column {
        CustomText(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomText(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}
