package com.joao01sb.eateasy.features.search.data.repository

import com.joao01sb.eateasy.core.data.local.dao.SearchDao
import com.joao01sb.eateasy.core.data.local.entity.SearchEntity
import com.joao01sb.eateasy.features.search.domain.repository.QueriesLocalRepository
import kotlinx.coroutines.flow.Flow

class QueriesLocalRepositoryImp(
    private val searchDao: SearchDao
) : QueriesLocalRepository{

    override fun allLastQueries(): Flow<List<String>> {
        return searchDao.getLastSearch()
    }

    override suspend fun insertQuery(query: String) {
        return searchDao.insertSearch(SearchEntity(query))
    }


}