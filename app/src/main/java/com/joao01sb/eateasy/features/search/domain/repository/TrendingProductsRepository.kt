package com.joao01sb.eateasy.features.search.domain.repository

import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface TrendingProductsRepository {

    suspend fun treadingProducts() : Flow<List<String>>

}