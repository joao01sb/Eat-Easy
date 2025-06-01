package com.joao01sb.eateasy.core.data.remote.reponse

import com.google.gson.annotations.SerializedName

data class MessageResponse(
    @SerializedName("message_id") val messageId: String,
    @SerializedName("order_id") val orderId: String?,
    @SerializedName("sender") val sender: String, // "client" ou "store"
    @SerializedName("content") val content: String,
    @SerializedName("timestamp") val timestamp: String,
    @SerializedName("read") val read: Boolean
)
