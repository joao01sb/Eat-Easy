package com.joao01sb.eateasy.features.home.data.usecase

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.flow.Flow

class GetAllProductsUseCaseImp(
    private val homeRepository: HomeRepository
) : GetAllProductsUseCase {

    override suspend fun invoke(): Flow<Resource<List<Product>>> {
        return homeRepository.getProducts()
    }
}