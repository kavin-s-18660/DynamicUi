package com.example.dynamicui.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DynamicUiViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    init {
        viewModelScope.launch {
            _products.value = repository.getAllProducts()
        }
    }

    fun filterByTab(tab: String) {
        viewModelScope.launch {
            _products.value = if (tab == "All Items") repository.getAllProducts()
            else repository.getProductsByCategory(tab)
        }
    }
}
