package com.joao01sb.eateasy.features.home.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.joao01sb.eateasy.core.domain.mocks.MocksProducts.productsSale
import com.joao01sb.eateasy.core.domain.model.Category
import com.joao01sb.eateasy.core.domain.model.Product
import com.joao01sb.eateasy.core.presentation.composables.ProductCard
import com.joao01sb.eateasy.core.presentation.composables.ProductCategoryList
import com.joao01sb.eateasy.core.presentation.composables.SaleProduct
import com.joao01sb.eateasy.core.presentation.composables.SearchLocationAndOptions
import com.joao01sb.eateasy.core.presentation.composables.SearchProduct
import com.joao01sb.eateasy.core.presentation.theme.BackgroundGray
import com.joao01sb.eateasy.core.presentation.theme.DarkGray
import com.joao01sb.eateasy.core.presentation.theme.MediumGray
import com.joao01sb.eateasy.features.home.presentation.state.HomeState

@Preview(showSystemUi = true)
@Composable
fun HomeScreen(
    state: HomeState = HomeState(),
    onSearch: (String) -> Unit = {}
) {
    Surface(
        color = BackgroundGray
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            SearchLocationAndOptions()
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            TitleOfert()
            Spacer(modifier = Modifier.padding(vertical = 4.dp))
            SearchProduct(state.query, onSearch)
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            BannerProduct(state.productsSale)
            CategoriesScreen(state.categories)
            AnimatedProductScreen(state)
        }

    }
}

@Composable
fun AnimatedProductScreen(state: HomeState) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        state.categories.forEachIndexed { categoryIndex, category ->
            val categoryProducts = state.allProducts.filter { it.idCategory == category.id }

            if (categoryProducts.isNotEmpty()) {
                item(key = "category_${category.id}") {
                    AnimatedVisibility(
                        visible = true,
                        enter = slideInVertically(
                            initialOffsetY = { it / 2 },
                            animationSpec = tween(200, delayMillis = categoryIndex * 80)
                        ) + fadeIn(animationSpec = tween(200))
                    ) {
                        Text(
                            text = category.name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                            color = DarkGray
                        )
                    }
                }

                item(key = "products_${category.id}") {
                    AnimatedVisibility(
                        visible = true,
                        enter = slideInHorizontally(
                            initialOffsetX = { it },
                            animationSpec = tween(300, delayMillis = categoryIndex * 100)
                        ) + fadeIn(animationSpec = tween(300))
                    ) {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            itemsIndexed(
                                items = categoryProducts,
                                key = { _, product -> product.idProduct }
                            ) { index, product ->
                                AnimatedVisibility(
                                    visible = true,
                                    enter = scaleIn(
                                        animationSpec = tween(
                                            200,
                                            delayMillis = (categoryIndex * 150) + (index * 25)
                                        )
                                    ) + fadeIn()
                                ) {
                                    ProductCard(
                                        name = product.name,
                                        price = "R$ ${product.price}",
                                        imageUrl = product.imageUrl
                                    )
                                }
                            }
                        }
                    }
                }

                item(key = "spacer_${category.id}") {
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}


@Composable
private fun ColumnScope.TitleOfert() {
    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = "Escolha o melhor prato para você!",
        fontSize = 20.sp,
        fontWeight = FontWeight.W500,
        color = DarkGray
    )
}

@Composable
private fun BannerProduct(
    productsPromotional: List<Product>
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val peekWidth = screenWidth * 0.10f

    LazyRow(
        contentPadding = PaddingValues(
            start = 0.dp,
            end = peekWidth + 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth(),
        state = rememberLazyListState()
    ) {
        items(productsPromotional, itemContent = { product ->
            SaleProduct(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(16.dp),
                product = product
            )
        })
    }
}


@Composable
fun CategoryList(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    selectedCategory: String,
    onCategorySelected: (Category) -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val peekWidth = screenWidth * 0.10f

    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 0.dp,
            end = peekWidth + 8.dp,
            top = 4.dp,
            bottom = 4.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            CategoryChip(
                text = category.name,
                isSelected = category.name == selectedCategory,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Composable
fun CategoryChip(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier.clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        color = if (isSelected) Color(0xFFFF5722) else Color.White,
        contentColor = if (isSelected) Color.White else Color.Black
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSelected) Color.White else MediumGray
        )
    }
}

@Composable
fun CategoriesScreen(
    categories: List<Category>
) {
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    CategoryList(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        categories = categories,
        selectedCategory = selectedCategory.name,
        onCategorySelected = { selectedCategory = it }
    )
}



