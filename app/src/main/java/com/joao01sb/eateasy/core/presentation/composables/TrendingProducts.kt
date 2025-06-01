package com.joao01sb.eateasy.core.presentation.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TrendingProducts(
    modifier: Modifier = Modifier,
    productNameList: List<String>
) {
    Column(
        modifier = modifier
    ){
        Text("Em Alta")
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            maxItemsInEachRow = 4
        ) {
            productNameList.forEach {
                TrendingProductItem(it)
            }
        }
    }
}

@Preview
@Composable
fun TrendingProductsPreview() {
    TrendingProducts(productNameList = listOf("aaaaaad","Sorvetes frios", "Bebuidas", "Almoço", "Jantar", "Cafer da manha", "Lanches", "Sorvertes quntes"))
}