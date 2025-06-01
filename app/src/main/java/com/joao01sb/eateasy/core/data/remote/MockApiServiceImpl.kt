package com.joao01sb.eateasy.core.data.remote

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.data.remote.reponse.MessageResponse
import com.joao01sb.eateasy.core.data.remote.reponse.OrderResponse
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.domain.model.SearchResultProduct
import com.joao01sb.eateasy.core.utils.JsonUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import kotlin.random.Random

class MockApiServiceImpl(
    private val context: Context
) : ApiService {

    private val gson = Gson()

    override suspend fun getProducts(query: String): Flow<List<ProductResponse>> =
        flow {
            try {
                val fileName = "$query.json"
                val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                    ?: throw IOException("Arquivo não encontrado: $fileName")
                val products = jsonFromFile.let {
                    val type = object : TypeToken<List<ProductResponse>>() {}.type
                    gson.fromJson<List<ProductResponse>>(it, type)
                } ?: emptyList()
                emit(products)
            } catch (e: IOException) {
                Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
                throw e
            } catch (e: JsonParseException) {
                Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
                throw e
            }
        }


    override suspend fun getCategories(query: String): Flow<List<ItemCategoryResponse>> =
        flow {
            try {
                val fileName = "$query.json"
                val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                    ?: throw IOException("Arquivo não encontrado: $fileName")
                val categories = jsonFromFile.let {
                    val type = object : TypeToken<List<ItemCategoryResponse>>() {}.type
                    gson.fromJson<List<ItemCategoryResponse>>(it, type)
                } ?: emptyList()
                emit(categories)
            } catch (e: IOException) {
                Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
                throw e
            } catch (e: JsonParseException) {
                Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
                throw e
            }
        }


    override suspend fun getOrders(query: String): Flow<List<OrderResponse>> =
        flow {
            try {
                val fileName = "$query.json"
                val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                    ?: throw IOException("Arquivo não encontrado: $fileName")
                val orders = jsonFromFile.let {
                    val type = object : TypeToken<List<OrderResponse>>() {}.type
                    gson.fromJson<List<OrderResponse>>(it, type)
                } ?: emptyList()
                emit(orders)
            } catch (e: IOException) {
                Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
                throw e
            } catch (e: JsonParseException) {
                Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
                throw e
            }
        }


    override suspend fun getMessages(query: String): Flow<List<MessageResponse>> =
        flow {
            try {
                val fileName = "$query.json"
                val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                    ?: throw IOException("Arquivo não encontrado: $fileName")
                val messages = jsonFromFile.let {
                    val type = object : TypeToken<List<MessageResponse>>() {}.type
                    gson.fromJson<List<MessageResponse>>(it, type)
                } ?: emptyList()
                emit(messages)
            } catch (e: IOException) {
                Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
                throw e
            } catch (e: JsonParseException) {
                Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
                throw e
            }
        }

    override suspend fun getProductByName(query: String): Flow<List<SearchResultProduct>> = flow {
        try {
            val fileName = "$query.json"
            val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                ?: throw IOException("Arquivo não encontrado: $fileName")
            val products = jsonFromFile.let {
                val type = object : TypeToken<List<SearchResultProduct>>() {}.type
                gson.fromJson<List<SearchResultProduct>>(it, type)
            } ?: emptyList()
            emit(products.filter { it.name.contains(query, ignoreCase = true) })
        } catch (e: IOException) {
            Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
            throw e
        } catch (e: JsonParseException) {
            Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
            throw e
        }
    }

    override suspend fun getTrendingProducts(query: String): Flow<List<String>> = flow {
        try {
            val fileName = "$query.json"
            val jsonFromFile = JsonUtils.getJsonDataFromAsset(context, fileName)
                ?: throw IOException("Arquivo não encontrado: $fileName")
            val products = jsonFromFile.let {
                val type = object : TypeToken<List<SearchResultProduct>>() {}.type
                gson.fromJson<List<SearchResultProduct>>(it, type)
            } ?: emptyList()
            emit(products.map { it.name }.chunked(5)[0])
        } catch (e: IOException) {
            Log.e("MockApiService", "Erro ao ler arquivo JSON: ${e.message}")
            throw e
        } catch (e: JsonParseException) {
            Log.e("MockApiService", "Erro ao fazer parse do JSON: ${e.message}")
            throw e
        }
    }


}