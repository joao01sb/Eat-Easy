package com.joao01sb.eateasy.features.search.data.source

import com.joao01sb.eateasy.core.data.local.dao.SearchDao
import com.joao01sb.eateasy.core.data.local.entity.SearchEntity
import com.joao01sb.eateasy.features.search.domain.source.QueriesLocalDataSource
import kotlinx.coroutines.flow.Flow

class QueriesLocalDataSourceImp(
    private val searchDao: SearchDao
) : QueriesLocalDataSource{
    override fun allLastQueries(): Flow<List<String>> {
        return searchDao.getLastSearch()
    }

    override suspend fun insertQuery(query: String) {
        searchDao.insertSearch(
            queryEntity = SearchEntity(
                query = query
            )
        )
    }
}