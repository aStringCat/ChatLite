package com.project.chat.ui

import androidx.lifecycle.ViewModel
import com.project.chat.data.Account
import com.project.chat.data.utils.LocalDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class ChatViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ChatUiState())
    val uiState: StateFlow<ChatUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val messages = LocalDataProvider.getAllMessages()
        val conversations = messages.groupBy {
            if (it.sender.id == uiState.value.currentChat?.id) {
                it.recipient
            } else {
                it.sender
            }
        }
        _uiState.update { currentState ->
            currentState.copy(
                conversations = conversations,
                currentChat = LocalDataProvider.getDefaultAccount()
            )
        }
    }

    fun openChat(account: Account) {
        val chatHistory = _uiState.value.conversations[account] ?: emptyList()
        _uiState.update {
            it.copy(
                isShowingHomePage = false,
                currentThread = chatHistory,
                currentChat = account
            )
        }
    }

    fun closeChat() {
        _uiState.update {
            it.copy(
                isShowingHomePage = true,
                currentThread = emptyList()
            )
        }
    }
}