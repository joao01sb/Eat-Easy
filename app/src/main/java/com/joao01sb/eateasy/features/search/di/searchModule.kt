package com.joao01sb.eateasy.features.search.di

import com.joao01sb.eateasy.core.data.local.dao.SearchDao
import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.features.search.data.repository.QueriesLocalRepositoryImp
import com.joao01sb.eateasy.features.search.data.repository.SearchRepositoryImp
import com.joao01sb.eateasy.features.search.data.repository.TrendingProductsRepositoryImp
import com.joao01sb.eateasy.features.search.data.source.QueriesLocalDataSourceImp
import com.joao01sb.eateasy.features.search.data.source.SearchDataSourceImp
import com.joao01sb.eateasy.features.search.data.source.TrendingProductsDataSourceImp
import com.joao01sb.eateasy.features.search.data.usecase.GetLastQueriesUseCaseImp
import com.joao01sb.eateasy.features.search.data.usecase.GetTrendingProductUseCaseImp
import com.joao01sb.eateasy.features.search.data.usecase.SearchProductsUseCaseImp
import com.joao01sb.eateasy.features.search.domain.repository.QueriesLocalRepository
import com.joao01sb.eateasy.features.search.domain.repository.SearchRepository
import com.joao01sb.eateasy.features.search.domain.repository.TrendingProductsRepository
import com.joao01sb.eateasy.features.search.domain.source.QueriesLocalDataSource
import com.joao01sb.eateasy.features.search.domain.source.SearchDataSource
import com.joao01sb.eateasy.features.search.domain.source.TrendingProductsDataSource
import com.joao01sb.eateasy.features.search.domain.usecase.GetLastQueriesUseCase
import com.joao01sb.eateasy.features.search.domain.usecase.GetTrendingProductsUseCase
import com.joao01sb.eateasy.features.search.domain.usecase.SearchProductsUseCase
import org.koin.dsl.module

val searchModule = module {

    single<QueriesLocalDataSource> {
        QueriesLocalDataSourceImp(searchDao = get<SearchDao>())
    }
    single<SearchDataSource> {
        SearchDataSourceImp(service = get<ApiService>())
    }
    single<TrendingProductsDataSource> {
        TrendingProductsDataSourceImp(service = get<ApiService>())
    }
    single<QueriesLocalRepository> {
        QueriesLocalRepositoryImp(searchDao = get<SearchDao>())
    }
    single<SearchRepository> {
        SearchRepositoryImp(dataSource = get<SearchDataSource>())
    }
    single<TrendingProductsRepository> {
        TrendingProductsRepositoryImp(trendingProductsDataSource = get<TrendingProductsDataSource>())
    }
    single<GetLastQueriesUseCase> {
        GetLastQueriesUseCaseImp(queriesLocal = get<QueriesLocalRepository>())
    }
    single<GetTrendingProductsUseCase> {
        GetTrendingProductUseCaseImp(trendingProductRepository = get<TrendingProductsRepository>())
    }
    single<SearchProductsUseCase> {
        SearchProductsUseCaseImp(
            searchProductsRepository = get<SearchRepository>(),
            queriesLocalRepository = get<QueriesLocalRepository>()
        )
    }

}