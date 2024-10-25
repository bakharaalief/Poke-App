package com.bakhdev.core_ui.helper

import androidx.compose.ui.graphics.Color
import com.bakhdev.core_ui.theme.blackBgPokemon
import com.bakhdev.core_ui.theme.blueBgPokemon
import com.bakhdev.core_ui.theme.brownBgPokemon
import com.bakhdev.core_ui.theme.grayBgPokemon
import com.bakhdev.core_ui.theme.greenBgPokemon
import com.bakhdev.core_ui.theme.pinkBgPokemon
import com.bakhdev.core_ui.theme.purpleBgPokemon
import com.bakhdev.core_ui.theme.redBgPokemon
import com.bakhdev.core_ui.theme.whiteBgPokemon
import com.bakhdev.core_ui.theme.yellowBgPokemon

object ColorHelper {
    fun getColorPicker(color: String): Color {
        return when (color.lowercase()) {
            "black" -> blackBgPokemon
            "blue" -> blueBgPokemon
            "brown" -> brownBgPokemon
            "gray" -> grayBgPokemon
            "green" -> greenBgPokemon
            "pink" -> pinkBgPokemon
            "purple" -> purpleBgPokemon
            "red" -> redBgPokemon
            "white" -> whiteBgPokemon
            "yellow" -> yellowBgPokemon
            else -> blackBgPokemon
        }
    }
}