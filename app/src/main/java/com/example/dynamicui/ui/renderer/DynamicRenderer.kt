package com.example.dynamicui.ui.renderer

import androidx.compose.runtime.Composable
import com.example.dynamicui.domain.model.Layout
import com.example.dynamicui.ui.components.DynamicLayout
import com.example.dynamicui.ui.components.DynamicComponent

sealed class UiEvent {
    data class Search(val query: String) : UiEvent()
    data class CartItemClick(val itemId: String) : UiEvent()
    object CustomizeSale : UiEvent()
    object Pay : UiEvent()
    data class CategoryClick(val categoryId: String) : UiEvent()
}

@Composable
fun RenderDynamicLayout(
    layout: Layout,
    onEvent: (UiEvent) -> Unit
) {
    DynamicLayout(layout) { component ->
        DynamicComponent(component, onEvent)
    }
}
