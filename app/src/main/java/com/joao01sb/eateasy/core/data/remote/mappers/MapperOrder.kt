package com.joao01sb.eateasy.core.data.remote.mappers

import com.joao01sb.eateasy.core.data.remote.reponse.OrderItemResponse
import com.joao01sb.eateasy.core.data.remote.reponse.OrderResponse
import com.joao01sb.eateasy.core.domain.model.Order
import com.joao01sb.eateasy.core.domain.model.OrderItem

fun OrderResponse.toModel() = Order(
    orderId = orderId,
    createdAt = createdAt,
    status = status,
    totalPrice = totalPrice,
    items = items.map { it.toModel() }
)

fun OrderItemResponse.toModel() = OrderItem(
    productId = productId,
    name = name,
    quantity = quantity,
    price = price
)