package com.joao01sb.eateasy.features.search.presentation.state

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.domain.model.SearchResultProduct

data class State(
    val query: String = "",
    val trendingProducts: List<String> = listOf(),
    val productsQuery: List<SearchResultProduct> = listOf(),
    val lastQueries: List<String> = listOf()
)
