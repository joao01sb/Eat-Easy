package com.joao01sb.eateasy.features.search.domain.source

import kotlinx.coroutines.flow.Flow

interface QueriesLocalDataSource {

    fun allLastQueries() : Flow<List<String>>

    suspend fun insertQuery(query: String)

}