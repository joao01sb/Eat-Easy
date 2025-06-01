package com.joao01sb.eateasy.features.home.data.usecase

import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.usecase.GetProductsByCategoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map

class GetProductsByCategoryUseCaseImp(
    private val homeRepository: HomeRepository
) : GetProductsByCategoryUseCase{

    override suspend fun invoke(categoryId: Int): Flow<Resource<List<Product>>> {
        return homeRepository.getProducts().map { resource ->
            resource.map {
                it.filter { it.idCategory == categoryId }
            }
        }
    }

}