package com.bakhdev.pokeapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bakhdev.home.DetailScreen
import com.bakhdev.home.ui.HomeScreen

@Composable
fun NavigationGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable<Routes.Home> {
            HomeScreen()
        }
        composable<Routes.Detail> {
            DetailScreen()
        }
    }
}