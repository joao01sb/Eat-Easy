package com.joao01sb.eateasy.features.search.data.usecase

import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.core.utils.mapExceptionToErrorMessage
import com.joao01sb.eateasy.features.search.domain.repository.QueriesLocalRepository
import com.joao01sb.eateasy.features.search.domain.repository.SearchRepository
import com.joao01sb.eateasy.features.search.domain.usecase.SearchProductsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchProductsUseCaseImp(
    private val searchProductsRepository: SearchRepository,
    private val queriesLocalRepository: QueriesLocalRepository
) : SearchProductsUseCase {

    override suspend fun invoke(query: String): Flow<Resource<List<SearchResultProduct>>> = flow {
        try {
            queriesLocalRepository.insertQuery(query)
            searchProductsRepository.searchProduct(query).collect {
                emit(it)
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }


}