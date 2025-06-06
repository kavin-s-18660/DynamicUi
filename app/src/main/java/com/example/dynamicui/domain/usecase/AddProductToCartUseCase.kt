package com.example.dynamicui.domain.usecase

import com.example.dynamicui.domain.model.Product

class AddProductToCartUseCase {
    suspend operator fun invoke(product: Product) {
        // Implement cart logic here
    }
}
