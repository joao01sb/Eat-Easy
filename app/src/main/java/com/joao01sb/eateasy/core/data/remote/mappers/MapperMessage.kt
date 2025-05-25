package com.joao01sb.eateasy.core.data.remote.mappers

import com.joao01sb.eateasy.core.data.remote.reponse.MessageResponse
import com.joao01sb.eateasy.core.domain.model.Message

fun MessageResponse.toModel() = Message(
    messageId = messageId,
    orderId = orderId,
    sender = sender,
    content = content,
    timestamp = timestamp,
    read = read
)