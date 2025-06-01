package com.joao01sb.eateasy.core.domain.model

data class Order(
    val orderId: String = "",
    val createdAt: String = "",
    val status: String = "",
    val totalPrice: String = "",
    val items: List<OrderItem> = listOf()
)
