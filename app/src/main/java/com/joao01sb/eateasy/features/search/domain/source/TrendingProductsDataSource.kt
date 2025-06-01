package com.joao01sb.eateasy.features.search.domain.source

import kotlinx.coroutines.flow.Flow

interface TrendingProductsDataSource {

    suspend fun treadingProducts() : Flow<List<String>>

}