package com.project.chat.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.project.chat.data.Account
import com.project.chat.ui.components.NavigationBar
import com.project.chat.ui.utils.ContentType
import com.project.chat.ui.utils.NavigationType

@Composable
fun ChatHomeScreen(
    navigationType: NavigationType,
    contentType: ContentType,
    chatUiState: ChatUiState,
    onOpenChat: (Account) -> Unit,
    onCloseChat: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedDestination by remember { mutableStateOf("Chats") }

    if (navigationType == NavigationType.PERMANENT_NAVIGATION_DRAWER) {
        PermanentNavigationDrawer(
            drawerContent = {
                NavigationBar(
                    navigationType = navigationType,
                    selectedDestination = selectedDestination,
                    onDestinationSelected = { selectedDestination = it }
                )
            },
            modifier = modifier
        ) {
            // Content area
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Content for $selectedDestination")
            }
        }
    } else {
        Scaffold(
            bottomBar = {
                if (navigationType == NavigationType.BOTTOM_NAVIGATION) {
                    NavigationBar(
                        navigationType = navigationType,
                        selectedDestination = selectedDestination,
                        onDestinationSelected = { selectedDestination = it }
                    )
                }
            }
        ) { padding ->
            Row(
                modifier = modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                if (navigationType == NavigationType.NAVIGATION_RAIL) {
                    NavigationBar(
                        navigationType = navigationType,
                        selectedDestination = selectedDestination,
                        onDestinationSelected = { selectedDestination = it }
                    )
                }
                // Content area
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Content for $selectedDestination")
                }
            }
        }
    }
}

