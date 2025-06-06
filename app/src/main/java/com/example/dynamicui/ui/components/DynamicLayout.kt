package com.example.dynamicui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.dynamicui.domain.model.Layout
import com.example.dynamicui.domain.model.Component

@Composable
fun DynamicLayout(
    layout: Layout,
    renderComponent: @Composable (component: Component) -> Unit
) {
    val columns = layout.number_of_columns
    val columnWeights = remember(layout.column_definitions) { layout.column_definitions.map { parseWeight(it) } }
    val grouped = remember(layout.components, columns) { layout.components.chunked(columns) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        grouped.forEach { rowComponents ->
            Row(Modifier.fillMaxWidth()) {
                rowComponents.forEachIndexed { colIdx, component ->
                    Box(
                        Modifier
                            .weight(columnWeights.getOrElse(colIdx) { 1f })
                            .padding(4.dp)
                    ) {
                        renderComponent(component)
                    }
                }
            }
        }
    }
}

private fun parseWeight(def: String): Float = when {
    def.equals("auto", true) -> 1f
    def.endsWith("*") -> def.removeSuffix("*").toFloatOrNull() ?: 1f
    else -> def.toFloatOrNull() ?: 1f
}