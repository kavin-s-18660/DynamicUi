package com.example.dynamicui.domain.model

data class Layout(
    val layout_id: Long,
    val layout_name: String,
    val number_of_columns: Int,
    val components: List<Component>,
    val column_definitions: List<String>
)

data class Component(
    val section_id: Int,
    val element: String,
    val style: String
)
