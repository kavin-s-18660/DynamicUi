package com.example.dynamicui.di

import android.content.Context
import com.example.dynamicui.data.repository.LayoutRepositoryImpl
import com.example.dynamicui.domain.repository.LayoutRepository
import com.example.dynamicui.domain.usecase.GetLayoutUseCase
import com.example.dynamicui.ui.viewmodel.LayoutViewModel

object AppModule {
    fun provideLayoutRepository(context: Context): LayoutRepository =
        LayoutRepositoryImpl(context)

    fun provideGetLayoutUseCase(repository: LayoutRepository): GetLayoutUseCase =
        GetLayoutUseCase(repository)

    fun provideLayoutViewModel(context: Context): LayoutViewModel {
        val repo = provideLayoutRepository(context)
        val useCase = provideGetLayoutUseCase(repo)
        return LayoutViewModel(useCase)
    }
}
