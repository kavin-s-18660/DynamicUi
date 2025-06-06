package com.example.dynamicui.util

 import kotlinx.serialization.Serializable
 import kotlinx.serialization.json.Json

@Serializable
data class DynamicUiConfig(
    val layout: DynamicUiNode
)

@Serializable
data class DynamicUiNode(
    val type: String,
    val children: List<DynamicUiNode>? = null,
    val icon: String? = null,
    val text: String? = null,
    val label: String? = null,
    val tabs: List<TabConfig>? = null,
    val selected: Boolean? = null,
    val items: String? = null,
    val style: String? = null,
    val fullWidth: Boolean? = null,
    val onClick: String? = null,
    val onTabSelected: String? = null
)

@Serializable
data class TabConfig(
    val label: String,
    val selected: Boolean? = null
)

object DynamicUiParser {
    private val json = Json { ignoreUnknownKeys = true }

    fun parse(jsonString: String): DynamicUiConfig =
        json.decodeFromString(jsonString)
}