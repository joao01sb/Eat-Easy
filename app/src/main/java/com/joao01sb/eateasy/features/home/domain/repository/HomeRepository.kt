package com.joao01sb.eateasy.features.home.domain.repository

import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Message
import com.joao01sb.eateasy.core.domain.model.Order
import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getProducts() : Flow<Resource<List<Product>>>
    suspend fun getCategories() : Flow<Resource<List<Category>>>
    suspend fun getOrders() : Flow<Resource<List<Order>>>
    suspend fun getMessages() : Flow<Resource<List<Message>>>


}