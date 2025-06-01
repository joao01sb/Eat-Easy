package com.joao01sb.eateasy.features.home.presentation.state

import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Product

data class HomeState(
    val location: String = "",
    val productsSale: List<Product> = listOf(),
    val categories: List<Category> = listOf(),
    val allProducts: List<Product> = listOf(),
    val query: String = ""
)
