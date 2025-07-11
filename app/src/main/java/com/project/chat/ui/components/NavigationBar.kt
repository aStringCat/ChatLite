package com.project.chat.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.project.chat.ui.utils.NavigationType

data class NavigationItem(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

@Composable
fun NavigationBar(
    navigationType: NavigationType,
    selectedDestination: String,
    onDestinationSelected: (String) -> Unit
) {
    val navigationItems = listOf(
        NavigationItem("Chats", Icons.AutoMirrored.Filled.Chat, Icons.AutoMirrored.Filled.Chat),
        NavigationItem("Profile", Icons.Default.People, Icons.Default.People)
    )

    when (navigationType) {
        NavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            PermanentDrawerSheet {
                navigationItems.forEach { item ->
                    NavigationDrawerItem(
                        label = { Text(item.route) },
                        icon = { Icon(item.selectedIcon, contentDescription = item.route) },
                        selected = selectedDestination == item.route,
                        onClick = { onDestinationSelected(item.route) }
                    )
                }
            }
        }
        NavigationType.NAVIGATION_RAIL -> {
            NavigationRail {
                navigationItems.forEach { item ->
                    NavigationRailItem(
                        label = { Text(item.route) },
                        icon = { Icon(item.selectedIcon, contentDescription = item.route) },
                        selected = selectedDestination == item.route,
                        onClick = { onDestinationSelected(item.route) }
                    )
                }
            }
        }
        else -> {
            NavigationBar {
                navigationItems.forEach { item ->
                    NavigationBarItem(
                        label = { Text(item.route) },
                        icon = { Icon(item.selectedIcon, contentDescription = item.route) },
                        selected = selectedDestination == item.route,
                        onClick = { onDestinationSelected(item.route) }
                    )
                }
            }
        }
    }
}