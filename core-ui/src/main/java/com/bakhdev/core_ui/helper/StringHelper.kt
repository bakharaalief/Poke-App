package com.bakhdev.core_ui.helper

object StringHelper {
    fun Int.toPokemonIndex(): String {
        return "#${this.toString().padStart(3, '0')}"
    }
}