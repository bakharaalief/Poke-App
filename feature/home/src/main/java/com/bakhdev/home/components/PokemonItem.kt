package com.bakhdev.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bakhdev.core_ui.component.text.CustomText
import com.bakhdev.core_ui.component.loadImage.LoadImage
import com.bakhdev.core_ui.helper.ColorHelper
import com.bakhdev.core_ui.helper.StringHelper.toPokemonIndex
import com.bakhdev.core_ui.theme.PokeAppTheme
import com.bakhdev.core_ui.theme.brownPokemon
import com.bakhdev.pokemon.helper.Dummy
import com.bakhdev.pokemon.model.PokemonUiModel
import java.util.Locale

@Composable
fun PokemonItem(pokemonUiModel: PokemonUiModel, onClickItem: (pokemonUiModel: PokemonUiModel) -> Unit) {
    Card(
        onClick = { onClickItem(pokemonUiModel) },
        modifier = Modifier.border(
            BorderStroke(3.dp, MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(18.dp)
        ),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = ColorHelper.getColorPicker(pokemonUiModel.color))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            LoadImage(modifier = Modifier.size(180.dp), url = pokemonUiModel.url, desc = "poke image")

            CustomText(
                modifier = Modifier.fillMaxWidth(),
                text = pokemonUiModel.id.toPokemonIndex(),
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = brownPokemon
            )

            Spacer(modifier = Modifier.height(5.dp))

            CustomText(
                modifier = Modifier.fillMaxWidth(),
                text = pokemonUiModel.name.capitalize(Locale.ROOT),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PokemonItemPreview() {
    PokeAppTheme(
        dynamicColor = false
    ) {
        PokemonItem(pokemonUiModel = Dummy.createPokemonDummy(), onClickItem = {})
    }
}