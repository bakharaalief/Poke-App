package com.bakhdev.pokeapp.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bakhdev.core_ui.component.CustomText
import com.bakhdev.core_ui.theme.PokeAppTheme
import com.bakhdev.core_ui.theme.redPokemon

@Composable
fun BottomNavigation(
    navController: NavController,
    items: List<BottomNavigationItem>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBorderColor = MaterialTheme.colorScheme.onPrimary

    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                drawLine(
                    color = bottomBorderColor,
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(
                        size.width,
                        0f
                    ),
                    strokeWidth = 5.dp.toPx()
                )
            },
        containerColor = MaterialTheme.colorScheme.primary,
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
                    CustomText(
                        text = bottomNavigationItem.title,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()
    val listBottomNavigationItem = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Detail
    )

    PokeAppTheme(
        dynamicColor = false
    ) {
        BottomNavigation(
            navController = navController,
            items = listBottomNavigationItem
        )
    }
}