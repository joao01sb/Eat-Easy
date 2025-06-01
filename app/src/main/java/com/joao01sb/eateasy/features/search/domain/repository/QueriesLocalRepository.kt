package com.joao01sb.eateasy.features.search.domain.repository

import kotlinx.coroutines.flow.Flow

interface QueriesLocalRepository {

    fun allLastQueries() : Flow<List<String>>

    suspend fun insertQuery(query: String)
}