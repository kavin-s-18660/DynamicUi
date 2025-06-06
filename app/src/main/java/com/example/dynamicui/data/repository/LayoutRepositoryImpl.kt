package com.example.dynamicui.data.repository

import android.content.Context
import com.example.dynamicui.domain.model.Layout
import com.example.dynamicui.domain.repository.LayoutRepository
import com.example.dynamicui.util.JsonUtil

class LayoutRepositoryImpl(
    private val context: Context
) : LayoutRepository {
    override suspend fun getLayout(): Layout {
        val json = JsonUtil.loadJsonFromAsset(context, "layout.json")
        return JsonUtil.fromJson<Layout>(json)
    }
}
