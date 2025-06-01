package com.joao01sb.eateasy.features.search.data.repository

import com.joao01sb.eateasy.features.search.domain.repository.TrendingProductsRepository
import com.joao01sb.eateasy.features.search.domain.source.TrendingProductsDataSource
import kotlinx.coroutines.flow.Flow

class TrendingProductsRepositoryImp(
    private val trendingProductsDataSource: TrendingProductsDataSource
) : TrendingProductsRepository {

    override suspend fun treadingProducts(): Flow<List<String>> {
        return trendingProductsDataSource.treadingProducts()
    }
}