package com.example.dynamicui.domain.usecase

import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.domain.repository.ProductRepository

class FilterProductsByTabUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(category: String): List<Product> =
        if (category == "All Items") repository.getAllProducts()
        else repository.getProductsByCategory(category)
}
