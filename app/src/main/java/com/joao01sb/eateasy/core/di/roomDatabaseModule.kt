package com.joao01sb.eateasy.core.di

import androidx.room.Room
import com.joao01sb.eateasy.core.data.local.dao.SearchDao
import com.joao01sb.eateasy.core.data.local.database.SearchDatabase
import com.joao01sb.eateasy.core.utils.Constants
import org.koin.dsl.module

val module = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = SearchDatabase::class.java,
            name = Constants.searchDatabaseName
        ).build()
    }
    single<SearchDao> {
        val database = get<SearchDatabase>()
        database.serachDao()
    }
}