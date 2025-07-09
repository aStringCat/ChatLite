package com.project.chat.data.utils

object LocalDataProvider {

    private val allAccounts = listOf(
        Account(
            id = 1L,
            name = R.string.account_name_1,
            email = R.string.account_email_1,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 2L,
            name = R.string.account_name_2,
            email = R.string.account_email_2,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 3L,
            name = R.string.account_name_3,
            email = R.string.account_email_3,
            avatar = R.drawable.ic_launcher_foreground
        ),
        Account(
            id = 4L,
            name = R.string.account_name_4,
            email = R.string.account_email_4,
            avatar = R.drawable.ic_launcher_foreground
        )
    )

    private val allMessages = listOf(
        Message(
            id = 1,
            sender = allAccounts[0],
            recipient = allAccounts[1],
            subject = R.string.message_subject_1,
            body = R.string.message_body_1,
            createdAt = R.string.message_time_1
        ),
        Message(
            id = 2,
            sender = allAccounts[1],
            recipient = allAccounts[0],
            subject = R.string.message_subject_2,
            body = R.string.message_body_2,
            createdAt = R.string.message_time_2
        ),
        Message(
            id = 3,
            sender = allAccounts[2],
            recipient = allAccounts[0],
            subject = R.string.message_subject_3,
            body = R.string.message_body_3,
            createdAt = R.string.message_time_3
        ),
        Message(
            id = 4,
            sender = allAccounts[3],
            recipient = allAccounts[0],
            subject = R.string.message_subject_4,
            body = R.string.message_body_4,
            createdAt = R.string.message_time_4
        )
    )

    /**
     * 返回所有消息的列表
     */
    fun getAllMessages(): List<Message> = allMessages

    /**
     * 获取默认选中的账户
     */
    fun getDefaultAccount(): Account = allAccounts[0]
}