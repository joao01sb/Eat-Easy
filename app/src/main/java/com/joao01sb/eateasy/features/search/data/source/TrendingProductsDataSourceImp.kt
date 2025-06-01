package com.joao01sb.eateasy.features.search.data.source

import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.features.search.domain.source.TrendingProductsDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrendingProductsDataSourceImp(
    private val service: ApiService
) : TrendingProductsDataSource {

    override suspend fun treadingProducts(): Flow<List<String>> = flow {
        try {
            service.getTrendingProducts("").collect {
                emit(it)
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}