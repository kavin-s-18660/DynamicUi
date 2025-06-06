package com.example.dynamicui.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.example.dynamicui.domain.model.Component
import com.example.dynamicui.ui.renderer.UiEvent

@Composable
fun DynamicComponent(
    component: Component,
    onEvent: (UiEvent) -> Unit = {}
) {
    when (component.element) {
        "ItemSearchBar" -> SearchBar(onSearch = { query -> onEvent(UiEvent.Search(query)) })
        "CartItemsGrid" -> ItemsGrid(onItemClick = { id -> onEvent(UiEvent.CartItemClick(id)) })
        "SalesCustomizationButtons" -> SalesCustomizationButtons(style = component.style, onClick = { onEvent(UiEvent.CustomizeSale) })
        "PaymentExpressGrid" -> PaymentExpressGrid(onPay = { onEvent(UiEvent.Pay) })
        "CategoryProductsGrid" -> CategoryProductsGrid(style = component.style, onCategoryClick = { id -> onEvent(UiEvent.CategoryClick(id)) })
        "TotalViewGrid" -> TotalViewGrid()
        else -> Text("Unknown Component: ${component.element}")
    }
}

@Composable fun SearchBar(onSearch: (String) -> Unit) {
    var text = ""
    TextField(value = text, onValueChange = { text = it }, label = { Text("Search") })
}

@Composable fun ItemsGrid(onItemClick: (String) -> Unit) {
    Text("Cart Items Grid")
}

@Composable fun SalesCustomizationButtons(style: String, onClick: () -> Unit) {
    Button(onClick = onClick) { Text("Sales Customization") }
}

@Composable fun PaymentExpressGrid(onPay: () -> Unit) {
    Button(onClick = onPay) { Text("Pay") }
}

@Composable fun CategoryProductsGrid(style: String, onCategoryClick: (String) -> Unit) {
    Text("Category Products Grid - $style")
}

@Composable fun TotalViewGrid() {
    Text("Total: $0.00")
}
