package com.project.chat.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.project.chat.ui.utils.ContentType
import com.project.chat.ui.utils.NavigationType

@Composable
fun ChatApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
) {
    val navigationType: NavigationType
    val contentType: ContentType
    val viewModel: ChatViewModel = viewModel()
    val chatUiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = NavigationType.NAVIGATION_RAIL
            contentType = ContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = NavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ContentType.LIST_AND_DETAIL
        }

        else -> {
            navigationType = NavigationType.BOTTOM_NAVIGATION
            contentType = ContentType.LIST_ONLY
        }
    }
    ChatHomeScreen(
        navigationType = navigationType,
        contentType = contentType,
        chatUiState = chatUiState,
        onOpenChat = { account -> viewModel.openChat(account) },
        onCloseChat = { viewModel.closeChat() },
        modifier = modifier,
    )
}
