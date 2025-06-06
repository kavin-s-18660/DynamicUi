package com.example.dynamicui.domain.usecase

import com.example.dynamicui.domain.model.Layout
import com.example.dynamicui.domain.repository.LayoutRepository

class GetLayoutUseCase(private val repository: LayoutRepository) {
    suspend operator fun invoke(): Layout = repository.getLayout()
}
