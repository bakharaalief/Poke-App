package com.bakhdev.pokeapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.bakhdev.pokeapp.component.BottomNavigation
import com.bakhdev.pokeapp.component.BottomNavigationItem
import com.bakhdev.pokeapp.navigation.NavigationGraph

@Composable
@Preview
fun MainScreen() {
    val listBottomNavigationItem = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Detail
    )
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController = navController,
                items = listBottomNavigationItem
            )
        }
    ) { padding ->
        NavigationGraph(
            modifier = Modifier.padding(padding),
            navController = navController
        )
    }
}