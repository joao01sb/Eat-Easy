package com.joao01sb.eateasy.features.home.data.usecase

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.usecase.GetPromotionalProductsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetPromotionalProductsUseCaseImp(
    private val homeRepository: HomeRepository
) : GetPromotionalProductsUseCase{

    override suspend fun invoke(): Flow<Resource<List<Product>>> {
        return homeRepository.getProducts().map { resource ->
            resource.map { product ->
                product.filter { it.promotionalProduct }
            }
        }
    }

}