package com.project.chat.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.project.chat.data.Account
import com.project.chat.ui.components.NavigationBar
import com.project.chat.ui.screens.ChatDetailScreen
import com.project.chat.ui.screens.ConversationScreen
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
            AppContent(
                contentType = contentType,
                chatUiState = chatUiState,
                onOpenChat = onOpenChat,
                onCloseChat = onCloseChat
            )
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
                AppContent(
                    contentType = contentType,
                    chatUiState = chatUiState,
                    onOpenChat = onOpenChat,
                    onCloseChat = onCloseChat
                )
            }
        }
    }
}

@Composable
private fun AppContent(
    contentType: ContentType,
    chatUiState: ChatUiState,
    onOpenChat: (Account) -> Unit,
    onCloseChat: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (contentType == ContentType.LIST_AND_DETAIL) {
        Row(modifier = modifier.fillMaxSize()) {
            ConversationScreen(
                conversations = chatUiState.conversations,
                onConversationClick = onOpenChat,
                modifier = Modifier.weight(1f)
            )
            ChatDetailScreen(
                currentChat = chatUiState.currentChat,
                currentThread = chatUiState.currentThread,
                modifier = Modifier.weight(2f)
            )
        }
    } else {
        if (chatUiState.isShowingHomePage) {
            ConversationScreen(
                conversations = chatUiState.conversations,
                onConversationClick = onOpenChat,
                modifier = modifier.fillMaxSize()
            )
        } else {
            ChatDetailScreen(
                currentChat = chatUiState.currentChat,
                currentThread = chatUiState.currentThread,
                modifier = modifier.fillMaxSize()
            )
            BackHandler { onCloseChat() }
        }
    }
}
