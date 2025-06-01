package com.joao01sb.eateasy.features.home.di

import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.features.home.data.repository.HomeRepositoryImp
import com.joao01sb.eateasy.features.home.data.source.HomeDataSourceImp
import com.joao01sb.eateasy.features.home.data.usecase.GetAllCategoriesUseCaseImp
import com.joao01sb.eateasy.features.home.data.usecase.GetAllProductsUseCaseImp
import com.joao01sb.eateasy.features.home.data.usecase.GetProductsByCategoryUseCaseImp
import com.joao01sb.eateasy.features.home.data.usecase.GetPromotionalProductsUseCaseImp
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.usecase.GetAllProductsUseCase
import com.joao01sb.eateasy.features.home.domain.usecase.GetCategoriesUseCase
import com.joao01sb.eateasy.features.home.domain.usecase.GetProductsByCategoryUseCase
import com.joao01sb.eateasy.features.home.domain.usecase.GetPromotionalProductsUseCase
import com.joao01sb.eateasy.features.home.presentation.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {

    factory<HomeRepository> {
        HomeRepositoryImp(homeDataSourceImp = HomeDataSourceImp(get<ApiService>()))
    }
    factory<GetAllProductsUseCase> {
        GetAllProductsUseCaseImp(homeRepository = get<HomeRepository>())
    }
    factory<GetCategoriesUseCase> {
        GetAllCategoriesUseCaseImp(homeRepository = get<HomeRepository>())
    }
    factory<GetProductsByCategoryUseCase> {
        GetProductsByCategoryUseCaseImp(homeRepository = get<HomeRepository>())
    }
    factory<GetPromotionalProductsUseCase> {
        GetPromotionalProductsUseCaseImp(homeRepository = get<HomeRepository>())
    }
    viewModel { HomeViewModel(get(), get(), get()) }

}