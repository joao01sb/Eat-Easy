package com.joao01sb.eateasy.core.domain.model

import com.google.gson.annotations.SerializedName

data class Message(
    val messageId: String = "",
    val orderId: String? = null,
    val sender: String = "",
    val content: String = "",
    val timestamp: String = "",
    val read: Boolean = false
)
