package com.joao01sb.eateasy.features.search.domain.usecase

import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface SearchProductsUseCase {

    suspend operator fun invoke(query: String): Flow<Resource<List<SearchResultProduct>>>

}