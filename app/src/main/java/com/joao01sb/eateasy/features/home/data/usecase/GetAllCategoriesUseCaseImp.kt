package com.joao01sb.eateasy.features.home.data.usecase

import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.flow.Flow

class GetAllCategoriesUseCaseImp(
    private val homeRepository: HomeRepository
) : GetCategoriesUseCase {

    override suspend fun invoke(): Flow<Resource<List<Category>>> {
        return homeRepository.getCategories()
    }
}