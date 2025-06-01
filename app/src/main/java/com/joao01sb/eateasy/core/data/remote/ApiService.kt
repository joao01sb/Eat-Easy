package com.joao01sb.eateasy.core.data.remote

import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.data.remote.reponse.MessageResponse
import com.joao01sb.eateasy.core.data.remote.reponse.OrderResponse
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import kotlinx.coroutines.flow.Flow

interface ApiService {

    suspend fun getProducts(query: String): Flow<List<ProductResponse>>

    suspend fun getCategories(query: String): Flow<List<ItemCategoryResponse>>

    suspend fun getOrders(query: String): Flow<List<OrderResponse>>

    suspend fun getMessages(query: String): Flow<List<MessageResponse>>

    suspend fun getProductByName(query: String) : Flow<List<SearchResultProduct>>

    suspend fun getTrendingProducts(query: String) : Flow<List<String>>
}
