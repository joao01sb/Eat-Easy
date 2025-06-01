package com.joao01sb.eateasy.core.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joao01sb.eateasy.core.data.local.dao.SearchDao
import com.joao01sb.eateasy.core.data.local.entity.SearchEntity

@Database(
    entities = [SearchEntity::class],
    version = 2,
    exportSchema = false
)
abstract class SearchDatabase : RoomDatabase() {
    abstract fun serachDao() : SearchDao
}