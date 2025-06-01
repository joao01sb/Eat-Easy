package com.joao01sb.eateasy.features.search.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.query
import com.joao01sb.eateasy.core.presentation.composables.SearchLastItem
import com.joao01sb.eateasy.core.presentation.composables.SearchProductItem
import com.joao01sb.eateasy.core.presentation.composables.SearchQuery
import com.joao01sb.eateasy.core.presentation.composables.TrendingProducts
import com.joao01sb.eateasy.core.presentation.theme.BackgroundGray
import com.joao01sb.eateasy.features.search.presentation.state.State


@Composable
fun SearchScreen(
    state: State = State(),
    onChangeQuey: (String) -> Unit = {}
) {
    Surface(
        color = BackgroundGray
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchQuery(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "O que vai pedir hoje ?",
                query = state.query,
                onChange = onChangeQuey
            )
            HorizontalDivider(modifier = Modifier.padding(bottom = 4.dp))
            if (state.query.isBlank()) {
                TrendingProducts(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    productNameList = state.trendingProducts
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    items(state.lastQueries) {
                        SearchLastItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            query = it
                        )
                    }
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(state.productsQuery) {
                    SearchProductItem(
                        modifier = Modifier.fillMaxWidth(),
                        product = it
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()
}