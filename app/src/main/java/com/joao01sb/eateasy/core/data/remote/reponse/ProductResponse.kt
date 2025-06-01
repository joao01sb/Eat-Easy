package com.joao01sb.eateasy.core.data.remote.reponse

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("category") val category: String,
    @SerializedName("id_category") val idCategory: Int,
    @SerializedName("price") val price: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("is_promotional") val promotionalProduct: Boolean,
    @SerializedName("description") val description: String?
)
