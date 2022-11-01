package com.example.segundoapp

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(context: Context) {
    private val sp: SharedPreferences =
        context.getSharedPreferences("NOME_USUARIO", Context.MODE_PRIVATE)

    fun setString(key: String, str: String) {
        sp.edit().putString(key, str).apply()
    }

    fun getString(key: String): String {
        return sp.getString(key, "") ?: ""
    }
}