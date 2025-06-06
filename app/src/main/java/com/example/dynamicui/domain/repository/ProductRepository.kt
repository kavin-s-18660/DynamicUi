package com.example.dynamicui.domain.repository

import com.example.dynamicui.domain.model.Product

interface ProductRepository {
    suspend fun getAllProducts(): List<Product>
    suspend fun getProductsByCategory(category: String): List<Product>
}
