package com.project.chat.data

import androidx.annotation.StringRes

data class Message(
    val id: Long,
    val sender: Account,
    val recipient: Account,
    @StringRes val content: Int = -1,
    var createdAt: Int = -1
)
