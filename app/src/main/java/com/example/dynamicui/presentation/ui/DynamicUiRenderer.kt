package com.example.dynamicui.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.util.DynamicUiNode

@Composable
fun DynamicUiRenderer(
    node: DynamicUiNode,
    products: List<Product>,
    onTabSelected: (String) -> Unit,
    onProductClick: (Product) -> Unit,
    onGoToCart: () -> Unit
) {
    when (node.type) {
        "Column" -> Column(Modifier.fillMaxSize()) {
            node.children?.forEach {
                DynamicUiRenderer(it, products, onTabSelected, onProductClick, onGoToCart)
            }
        }
        "Row" -> Row(Modifier.fillMaxWidth()) {
            node.children?.forEach {
                DynamicUiRenderer(it, products, onTabSelected, onProductClick, onGoToCart)
            }
        }
        "Icon" -> IconButton(onClick = { /* handle icon */ }) {
            val icon = when (node.icon) {
                "menu" -> Icons.Default.Menu
                "search" -> Icons.Default.Search
                "filter_alt" -> Icons.Filled.Notifications
                "grid_view" -> Icons.Default.List
                "refresh" -> Icons.Default.Refresh
                "arrow_drop_down" -> Icons.Default.ArrowDropDown
                else -> Icons.Default.MoreVert
            }
            Icon(icon, contentDescription = node.icon)
        }
        "DropdownText" -> Row {
            Text(node.text ?: "", style = MaterialTheme.typography.titleLarge)
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        }
        "TabBar" -> {
            var selectedTabIndex by remember { mutableStateOf(node.tabs?.indexOfFirst { it.selected == true } ?: 0) }
            val tabs = node.tabs ?: emptyList()
            ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
                tabs.forEachIndexed { idx, tab ->
                    Tab(
                        selected = selectedTabIndex == idx,
                        onClick = {
                            selectedTabIndex = idx
                            onTabSelected(tab.label)
                        },
                        text = { Text(tab.label) }
                    )
                }
            }
        }
        "ListView" -> {
            LazyColumn {
                items(products.size) { idx ->
                    ProductListItem(product = products[idx], onClick = { onProductClick(products[idx]) })
                }
            }
        }
        "Button" -> Button(
            onClick = onGoToCart,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(node.text ?: "Button")
        }
        "Spacer" -> Spacer(modifier = Modifier.fillMaxSize(1f))
    }
}

@Composable
fun ProductListItem(product: Product, onClick: () -> Unit) {
    Row(Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        AsyncImage(
            model = product.imageUrl,
            contentDescription = product.title,
            modifier = Modifier.size(56.dp)
        )
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Text(product.title, style = MaterialTheme.typography.titleMedium)
            Text("₹${product.price}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
