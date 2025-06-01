package com.joao01sb.eateasy.features.home.data.repository

import com.joao01sb.eateasy.core.data.remote.mappers.toModel
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Message
import com.joao01sb.eateasy.core.domain.model.Order
import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.utils.Resource
import com.joao01sb.eateasy.features.home.domain.repository.HomeRepository
import com.joao01sb.eateasy.features.home.domain.source.HomeDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepositoryImp(
    private val homeDataSourceImp: HomeDataSource
) : HomeRepository {

    override suspend fun getProducts(): Flow<Resource<List<Product>>> {
        return homeDataSourceImp.getProducts().map { resource ->
            resource.map { productResponseList ->
                productResponseList.map { productResponse ->
                    productResponse.toModel()
                }
            }
        }
    }

    override suspend fun getCategories(): Flow<Resource<List<Category>>> {
        return homeDataSourceImp.getCategories().map { resource ->
            resource.map { categoryResponseList ->
                categoryResponseList.map { categoryResponse ->
                    categoryResponse.toModel()
                }
            }
        }
    }

    override suspend fun getOrders(): Flow<Resource<List<Order>>> {
        return homeDataSourceImp.getOrders().map { resource ->
            resource.map { orderResponses ->
                orderResponses.map { orderResponse ->
                    orderResponse.toModel()
                }
            }
        }
    }

    override suspend fun getMessages(): Flow<Resource<List<Message>>> {
        return homeDataSourceImp.getMessages().map { resource ->
            resource.map { messageResponses ->
                messageResponses.map { messageResponse ->
                    messageResponse.toModel()
                }
            }
        }
    }

}