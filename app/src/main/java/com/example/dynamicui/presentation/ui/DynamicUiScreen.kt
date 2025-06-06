package com.example.dynamicui.presentation.ui

import androidx.compose.runtime.*
import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.util.DynamicUiNode

@Composable
fun DynamicUiScreen(
    rootNode: DynamicUiNode,
    productList: List<Product>,
    onTabSelected: (String) -> Unit,
    onProductClick: (Product) -> Unit,
    onGoToCart: () -> Unit
) {
    DynamicUiRenderer(
        node = rootNode,
        products = productList,
        onTabSelected = onTabSelected,
        onProductClick = onProductClick,
        onGoToCart = onGoToCart
    )
}
