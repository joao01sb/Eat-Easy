package com.joao01sb.eateasy.features.search.data.repository

import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.search.domain.repository.SearchRepository
import com.joao01sb.eateasy.features.search.domain.source.SearchDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchRepositoryImp(
    private val dataSource: SearchDataSource
) : SearchRepository{

    override suspend fun searchProduct(query: String): Flow<Resource<List<SearchResultProduct>>> {
        return dataSource.searchProduct(query)
    }
}