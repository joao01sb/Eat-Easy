package com.joao01sb.eateasy.features.home.data.source

import com.joao01sb.eateasy.core.data.remote.ApiService
import com.joao01sb.eateasy.core.data.remote.mappers.toModel
import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.data.remote.reponse.MessageResponse
import com.joao01sb.eateasy.core.data.remote.reponse.OrderResponse
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.core.utils.mapExceptionToErrorMessage
import com.joao01sb.eateasy.features.home.domain.source.HomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeDataSourceImp(
    private val apiService: ApiService
) : HomeDataSource{

    override suspend fun getOrders(): Flow<Resource<List<OrderResponse>>> = flow {
        emit(Resource.Loading)
        try {
            apiService.getOrders("orders").collect {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }

    override suspend fun getMessages(): Flow<Resource<List<MessageResponse>>> = flow {
        emit(Resource.Loading)
        try {
            apiService.getMessages("messages").collect {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }

    override suspend fun getCategories(): Flow<Resource<List<ItemCategoryResponse>>> = flow {
        emit(Resource.Loading)
        try {
            apiService.getCategories("categories").collect {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }

    override suspend fun getProducts(): Flow<Resource<List<ProductResponse>>> = flow {
        emit(Resource.Loading)
        try {
            apiService.getProducts("products").collect {
                emit(Resource.Success(it))
            }
        } catch (e: Exception) {
            emit(Resource.Error(mapExceptionToErrorMessage(e)))
        }
    }

}