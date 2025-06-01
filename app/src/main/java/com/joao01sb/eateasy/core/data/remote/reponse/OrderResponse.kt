package com.joao01sb.eateasy.core.data.remote.reponse

import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("order_id") val orderId: String,
    @SerializedName("status") val status: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("total_price") val totalPrice: String,
    @SerializedName("items") val items: List<OrderItemResponse>
)

data class OrderItemResponse(
    @SerializedName("product_id") val productId: String,
    @SerializedName("name") val name: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("price") val price: String
)
