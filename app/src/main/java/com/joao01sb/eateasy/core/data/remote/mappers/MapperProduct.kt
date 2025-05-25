package com.joao01sb.eateasy.core.data.remote.mappers

import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.data.remote.reponse.ProductResponse
import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Product

fun ProductResponse.toModel() = Product(
    idProduct = id,
    message = description ?: "Empty category",
    category = category,
    idCategory = idCategory,
    name = name,
    price = price,
    imageUrl = imageUrl,
    promotionalProduct = promotionalProduct
)