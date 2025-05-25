package com.joao01sb.eateasy.core.data.remote.mappers

import com.joao01sb.eateasy.core.data.remote.reponse.ItemCategoryResponse
import com.joao01sb.eateasy.core.domain.model.Category

fun ItemCategoryResponse.toModel() = Category(
    id = id,
    name = name,
    imageUrl = imageUrl
)