package com.joao01sb.eateasy.features.home.domain.source

import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.data.remote.reponse.MessageResponse
import com.joao01sb.eateasy.core.data.remote.reponse.OrderResponse
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeDataSource {

    suspend fun getOrders() : Flow<Resource<List<OrderResponse>>>
    suspend fun getMessages() : Flow<Resource<List<MessageResponse>>>
    suspend fun getCategories() : Flow<Resource<List<ItemCategoryResponse>>>
    suspend fun getProducts() : Flow<Resource<List<ProductResponse>>>

}