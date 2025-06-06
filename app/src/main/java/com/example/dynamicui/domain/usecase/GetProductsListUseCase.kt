package com.example.dynamicui.domain.usecase

import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.domain.repository.ProductRepository

class GetProductsListUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): List<Product> = repository.getAllProducts()
}
