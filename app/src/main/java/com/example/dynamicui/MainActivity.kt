package com.example.dynamicui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dynamicui.di.AppModule
import com.example.dynamicui.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = AppModule.provideLayoutViewModel(this)
        viewModel.loadLayout()
        setContent {
            MainScreen(viewModel)
        }
    }
}
