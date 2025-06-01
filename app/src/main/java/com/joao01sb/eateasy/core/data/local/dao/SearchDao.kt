package com.joao01sb.eateasy.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.joao01sb.eateasy.core.data.local.entity.SearchEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchDao {

    @Query("SELECT * FROM Search")
    fun getLastSearch() : Flow<List<String>>

    @Insert(onConflict = IGNORE)
    suspend fun insertSearch(queryEntity: SearchEntity)
}