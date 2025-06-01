package com.joao01sb.eateasy.features.search.domain.usecase

import kotlinx.coroutines.flow.Flow

interface GetTrendingProductsUseCase {

    suspend operator fun invoke(): Flow<List<String>>

}