package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joao01sb.eateasy.core.domain.mocks.MocksProducts
import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.presentation.theme.DarkGray

@Composable
fun ProductCategoryList(category: Category, products: List<Product>) {
    Column {
        Text(
            text = category.name,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(16.dp),
            color = DarkGray
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products.filter { it.idCategory == category.id }) { index ->
                ProductCard(
                    name = index.name,
                    price = "R$ ${index.price}",
                    imageUrl = index.imageUrl
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

    }
}

@Preview
@Composable
fun ProductCategoryListPreview() {
    ProductCategoryList(Category(name = "Bebibas"), MocksProducts.productsSale)
}