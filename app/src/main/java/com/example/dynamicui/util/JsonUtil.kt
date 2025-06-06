package com.example.dynamicui.util

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object JsonUtil {
    inline fun <reified T> fromJson(json: String): T {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val adapter = moshi.adapter(T::class.java)
        return adapter.fromJson(json)!!
    }

    fun loadJsonFromAsset(context: Context, filename: String): String {
        return context.assets.open(filename).bufferedReader().use { it.readText() }
    }
}
