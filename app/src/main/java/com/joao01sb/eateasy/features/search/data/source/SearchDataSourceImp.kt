package com.joao01sb.eateasy.features.search.data.source

import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.core.utils.mapExceptionToErrorMessage
import com.joao01sb.eateasy.features.search.domain.source.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchDataSourceImp(
    private val service: ApiService
) : SearchDataSource{

    override suspend fun searchProduct(query: String): Flow<Resource<List<SearchResultProduct>>> = flow {
        emit(Resource.Loading)
        try {
            service.getProductByName(query).collect { response ->
                emit(Resource.Success(response))
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }
}