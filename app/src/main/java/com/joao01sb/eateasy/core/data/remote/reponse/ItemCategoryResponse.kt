package com.joao01sb.eateasy.core.data.remote.reponse

import com.google.gson.annotations.SerializedName

data class ItemCategoryResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val imageUrl: String
)
