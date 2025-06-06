package com.example.dynamicui.domain.repository

import com.example.dynamicui.domain.model.Layout

interface LayoutRepository {
    suspend fun getLayout(): Layout
}
