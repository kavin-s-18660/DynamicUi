package com.example.dynamicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.dynamicui.presentation.ui.DynamicUiScreen
import com.example.dynamicui.presentation.viewmodel.DynamicUiViewModel
import com.example.dynamicui.util.DynamicUiParser
import com.example.dynamicui.data.repository.ProductRepositoryImpl
import com.example.dynamicui.util.DynamicUiNode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repo = ProductRepositoryImpl()
        val viewModel = DynamicUiViewModel(repo)
        setContent {
            var rootNode by remember { mutableStateOf<DynamicUiNode?>(null) }
            LaunchedEffect(Unit) {
                val jsonString = withContext(Dispatchers.IO) {
                    assets.open("dynamic_ui_config.json").bufferedReader().use { it.readText() }
                }
                rootNode = DynamicUiParser.parse(jsonString).layout
            }
            rootNode?.let { node ->
                val products by viewModel.products.collectAsState()
                DynamicUiScreen(
                    rootNode = node,
                    productList = products,
                    onTabSelected = { tab -> viewModel.filterByTab(tab) },
                    onProductClick = { /* TODO: Handle click */ },
                    onGoToCart = { /* TODO: Handle cart navigation */ }
                )
            }
        }
    }
}
