package com.bakhdev.pokeapp.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {

    @Serializable
    data object Home : Routes("home")

    @Serializable
    data object Detail : Routes("detail")
}