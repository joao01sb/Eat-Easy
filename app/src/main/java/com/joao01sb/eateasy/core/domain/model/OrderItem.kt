package com.joao01sb.eateasy.core.domain.model

data class OrderItem(
    val productId: String = "",
    val name: String = "",
    val quantity: Int = 0,
    val price: String = ""
)