package com.example.dynamicui.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dynamicui.domain.model.Layout
import com.example.dynamicui.domain.usecase.GetLayoutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LayoutViewModel(private val useCase: GetLayoutUseCase) : ViewModel() {
    private val _layout = MutableStateFlow<Layout?>(null)
    val layout: StateFlow<Layout?> = _layout

    fun loadLayout() {
        viewModelScope.launch {
            _layout.value = useCase()
        }
    }
}
