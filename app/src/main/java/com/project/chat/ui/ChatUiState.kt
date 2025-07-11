package com.project.chat.ui

import com.project.chat.data.Account
import com.project.chat.data.Message

data class ChatUiState(
    val conversations: Map<Account, List<Message>> = emptyMap(),
    val currentThread: List<Message> = emptyList(),
    val currentChat: Account? = null,
    val isShowingHomePage: Boolean = true,
    val isLoading: Boolean = false,
    val error: String? = null
)