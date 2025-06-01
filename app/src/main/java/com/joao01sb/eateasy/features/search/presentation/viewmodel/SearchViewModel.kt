package com.joao01sb.eateasy.features.search.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.search.domain.usecase.GetLastQueriesUseCase
import com.joao01sb.eateasy.features.search.domain.usecase.GetTrendingProductsUseCase
import com.joao01sb.eateasy.features.search.domain.usecase.SearchProductsUseCase
import com.joao01sb.eateasy.features.search.presentation.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchProductsUseCase: SearchProductsUseCase,
    private val getTrendingProductsUseCase: GetTrendingProductsUseCase,
    private val getLastQueriesUseCase: GetLastQueriesUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch {
            getTrendingProductsUseCase().collect { trending ->
                _state.update { it.copy(trendingProducts = trending) }
            }
        }

        viewModelScope.launch {
            getLastQueriesUseCase().collect { queries ->
                _state.update { it.copy(lastQueries = queries) }
            }
        }
    }

    fun updateQuery(value: String) {
        _state.update { it.copy(query = value) }
    }

    fun searchProducts(query: String) {
        if (query.isBlank()) return

        viewModelScope.launch {
            searchProductsUseCase(query).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.update { it }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                productsQuery = resource.data
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it
                        }
                    }
                }
            }
        }
    }

}