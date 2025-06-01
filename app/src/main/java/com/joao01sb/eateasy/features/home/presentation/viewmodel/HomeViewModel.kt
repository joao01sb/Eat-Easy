package com.joao01sb.eateasy.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.usecase.GetAllProductsUseCase
import com.joao01sb.eateasy.features.home.domain.usecase.GetCategoriesUseCase
import com.joao01sb.eateasy.features.home.domain.usecase.GetPromotionalProductsUseCase
import com.joao01sb.eateasy.features.home.presentation.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getPromotionalProductsUseCase: GetPromotionalProductsUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _homeState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())
    val homeState: StateFlow<HomeState> = _homeState.asStateFlow()

    fun onSearch(newQuery: String) {
        _homeState.update { it.copy(query = newQuery) }

        // Aqui você pode filtrar os produtos, chamar API etc.
        // Exemplo simples:
//        val filtered = _homeState.value.allProducts.filter {
//            it.name.contains(newQuery, ignoreCase = true)
//        }

//        _homeState.update { it.copy(productsSale = filtered) }
    }


    init {
        loadData()

    }

    private fun loadData() {
        viewModelScope.launch {
            getCategoriesUseCase().collect { result ->
                if (result is Resource.Success)
                    _homeState.update { it.copy(categories = result.data) }
            }

            getPromotionalProductsUseCase().collect { result ->
                if (result is Resource.Success)
                    _homeState.update { it.copy(productsSale = result.data) }
            }

            getAllProductsUseCase().collect { result ->
                if (result is Resource.Success)
                    _homeState.update { it.copy(allProducts = result.data) }
            }
        }
    }

}