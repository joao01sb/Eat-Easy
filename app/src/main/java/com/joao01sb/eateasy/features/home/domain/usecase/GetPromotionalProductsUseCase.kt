package com.joao01sb.eateasy.features.home.domain.usecase

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetPromotionalProductsUseCase {
    suspend operator fun invoke(): Flow<Resource<List<Product>>>
}