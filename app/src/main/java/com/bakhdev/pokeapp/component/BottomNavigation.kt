package com.bakhdev.pokeapp.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(
    navController: NavController,
    items: List<BottomNavigationItem>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.primary
    ) {
        items.forEach { bottomNavigationItem ->

            val isTrue =
                currentDestination?.hierarchy?.any { it.hasRoute(bottomNavigationItem.route::class) } == true
            val icon = if (isTrue) {
                bottomNavigationItem.selectedIcon
            } else bottomNavigationItem.unselectedIcon

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Icon",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.secondary
                ),
                selected = isTrue,
                onClick = {
                    navController.navigate(bottomNavigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(
                        text = bottomNavigationItem.title,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    }
}