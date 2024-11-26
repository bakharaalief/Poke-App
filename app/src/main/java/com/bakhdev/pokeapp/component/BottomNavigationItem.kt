package com.bakhdev.pokeapp.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.bakhdev.pokeapp.navigation.Routes

sealed class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: Routes
) {
    data object Home :
        BottomNavigationItem("Home", Icons.Default.Home, Icons.Outlined.Home, Routes.Home)

    data object Detail :
        BottomNavigationItem("Detail", Icons.Default.Home, Icons.Outlined.Home, Routes.Detail)
}