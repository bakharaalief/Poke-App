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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import com.bakhdev.core_ui.helper.ColorHelper
import com.bakhdev.core_ui.helper.StringHelper.toPokemonIndex
import com.bakhdev.core_ui.theme.PokeAppTheme
import com.bakhdev.core_ui.theme.brownPokemon
import com.bakhdev.home.R
import com.bakhdev.pokemon.helper.Dummy
import com.bakhdev.pokemon.model.Pokemon
import java.util.Locale

@Composable
fun PokemonItem(pokemon: Pokemon, onClickItem: (pokemon: Pokemon) -> Unit) {

    Card(
        onClick = { onClickItem(pokemon) },
        modifier = Modifier.border(
            BorderStroke(3.dp, MaterialTheme.colorScheme.onPrimary),
            shape = RoundedCornerShape(18.dp)
        ),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = ColorHelper.getColorPicker(pokemon.color))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 18.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.url)
                    .build(),
                contentDescription = "poke image",
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(180.dp),
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = pokemon.id.toPokemonIndex(),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = brownPokemon
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = pokemon.name.capitalize(Locale.ROOT),
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
        PokemonItem(pokemon = Dummy.createPokemonDummy(), onClickItem = {})
    }
}