package com.joao01sb.eateasy.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    tableName = "Search",
    primaryKeys = ["query"]
)
data class SearchEntity(
    @ColumnInfo(name = "query")val query: String
)
