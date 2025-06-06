package com.example.dynamicui.data.repository

import com.example.dynamicui.domain.model.Product
import com.example.dynamicui.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {
    private val mockProducts = listOf(
        Product(1, "Analog Table Clock", 700, "https://example.com/images/analog_table_clock.jpg", "All Items"),
        Product(2, "Analog Wall Clock", 1859, "https://example.com/images/analog_wall_clock.jpg", "Wall Accents"),
        Product(3, "Artificial Decor Plant", 1419, "https://example.com/images/artificial_decor_plant.jpg", "Table Decor"),
        Product(4, "Bamboo Plant", 575, "https://example.com/images/bamboo_plant.jpg", "Table Decor"),
        Product(5, "Bedside Table Lamp", 999, "https://example.com/images/bedside_table_lamp.jpg", "Lamps & Lighting"),
        Product(6, "Blue Wrought Iron Human Figurine", 1900, "https://example.com/images/blue_wrought_iron_figurine.jpg", "Wall Accents"),
        Product(7, "Bonsai Plant", 396, "https://example.com/images/bonsai_plant.jpg", "Table Decor"),
        Product(8, "Buddha Art Panels", 700, "https://example.com/images/buddha_art_panels.jpg", "Wall Accents"),
        Product(9, "Cane Tray", 700, "https://example.com/images/cane_tray.jpg", "Table Decor")
    )
    override suspend fun getAllProducts(): List<Product> = mockProducts
    override suspend fun getProductsByCategory(category: String): List<Product> =
        if (category == "All Items") mockProducts else mockProducts.filter { it.category == category }
}
