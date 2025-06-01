package com.joao01sb.eateasy.features.search.data.usecase

import com.joao01sb.eateasy.features.search.domain.repository.QueriesLocalRepository
import com.joao01sb.eateasy.features.search.domain.usecase.GetLastQueriesUseCase
import kotlinx.coroutines.flow.Flow

class GetLastQueriesUseCaseImp(
    private val queriesLocal: QueriesLocalRepository
) : GetLastQueriesUseCase {

    override fun invoke(): Flow<List<String>> {
        return queriesLocal.allLastQueries()
    }
}