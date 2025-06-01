package com.joao01sb.eateasy.features.search.data.usecase

import com.joao01sb.eateasy.features.search.domain.repository.TrendingProductsRepository
import com.joao01sb.eateasy.features.search.domain.usecase.GetTrendingProductsUseCase
import kotlinx.coroutines.flow.Flow

class GetTrendingProductUseCaseImp(
    private val trendingProductRepository: TrendingProductsRepository
) : GetTrendingProductsUseCase {
    override suspend fun invoke(): Flow<List<String>> {
        return trendingProductRepository.treadingProducts()
    }
}