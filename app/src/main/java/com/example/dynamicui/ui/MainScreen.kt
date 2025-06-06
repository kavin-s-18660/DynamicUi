package com.example.dynamicui.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.dynamicui.ui.viewmodel.LayoutViewModel
import com.example.dynamicui.ui.renderer.RenderDynamicLayout
import com.example.dynamicui.ui.renderer.UiEvent

@Composable
fun MainScreen(viewModel: LayoutViewModel) {
    val layout by viewModel.layout.collectAsState()
    layout?.let {
        RenderDynamicLayout(it) { event ->
            // Handle UiEvent here (call viewModel functions, update state, etc)
        }
    }
}
