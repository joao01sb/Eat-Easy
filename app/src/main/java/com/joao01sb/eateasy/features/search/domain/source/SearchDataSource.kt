package com.joao01sb.eateasy.features.search.domain.source

import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SearchDataSource {

    suspend fun searchProduct(query: String) : Flow<Resource<List<SearchResultProduct>>>

}