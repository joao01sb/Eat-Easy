package com.joao01sb.eateasy.core.domain.model

data class ShoppingCartProduct(
    val name: String = "",
    val price: String = "",
    val imageUrl: String = "",
    val quantity: Int = 0,
    val categoty: String = "",
    val especification: String = ""
)
