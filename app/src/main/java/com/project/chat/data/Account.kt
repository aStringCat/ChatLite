package com.project.chat.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Account(
    /** Unique ID of a user **/
    val id: Long,
    @StringRes val name: Int,
    @DrawableRes val avatar: Int
)