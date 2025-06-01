package com.joao01sb.eateasy.core.domain.model

import java.util.Date

data class Product(
    val idProduct: Int = 0,
    val message: String = "",
    val category: String = "",
    val idCategory: Int = 0,
    val name: String = "",
    val price: String = "",
    val imageUrl: String = "",
    val promotionalProduct: Boolean = false
)