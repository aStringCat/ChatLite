package com.project.chat.data.utils

import com.project.chat.R
import com.project.chat.data.Account
import com.project.chat.data.Message

object LocalDataProvider {

    private val allAccounts = listOf(
        Account(
            id = 1L,
            name = R.string.account_name_1,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 2L,
            name = R.string.account_name_2,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 3L,
            name = R.string.account_name_3,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 4L,
            name = R.string.account_name_4,
            avatar = R.drawable.ic_launcher_foreground
        )
    )

    private val allMessages = listOf(
        Message(
            id = 1,
            sender = allAccounts[0],
            recipient = allAccounts[1],
            content = R.string.message_content_1,
            createdAt = R.string.message_time_1
        ),
        Message(
            id = 2,
            sender = allAccounts[1],
            recipient = allAccounts[0],
            content = R.string.message_content_2,
            createdAt = R.string.message_time_2
        ),
        Message(
            id = 3,
            sender = allAccounts[2],
            recipient = allAccounts[0],
            content = R.string.message_content_3,
            createdAt = R.string.message_time_3
        ),
        Message(
            id = 4,
            sender = allAccounts[3],
            recipient = allAccounts[0],
            content = R.string.message_content_4,
            createdAt = R.string.message_time_4
        )
    )

    fun getAllMessages(): List<Message> = allMessages

    fun getDefaultAccount(): Account = allAccounts[0]
}