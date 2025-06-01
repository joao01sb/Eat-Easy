package com.joao01sb.eateasy.features.home.domain.usecase

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GetProductsByCategoryUseCase {
    suspend operator fun invoke(categoryId: Int): Flow<Resource<List<Product>>>
}