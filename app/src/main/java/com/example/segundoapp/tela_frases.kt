package com.example.segundoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.segundoapp.databinding.ActivityTelaFrasesBinding

class tela_frases : AppCompatActivity() {
    private lateinit var preferences: MyPreferences
    private lateinit var binding: ActivityTelaFrasesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaFrasesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = MyPreferences(this)
        val nome = preferences.getString("NOME_USUARIO")
        binding.textApresentacao.text = "Olá, $nome!"
    }
}