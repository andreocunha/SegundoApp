package com.example.segundoapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.segundoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var preferences: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoGuardar.setOnClickListener(this)

        preferences = MyPreferences(this)

        verificaESalva()
    }

    override fun onClick(view: View) {
        verificaESalva()
    }

    fun verificaESalva(){
        // pegar o nome salvo na memoria interna do celular
        val result = preferences.getString("NOME_USUARIO")
        if(result == "") {
            val nome = binding.editTextPersonName.text
            Toast.makeText(applicationContext, nome, Toast.LENGTH_SHORT).show()
            if(nome.toString() != ""){
                preferences.setString("NOME_USUARIO", nome.toString())
                irParaTelaFrases()
            }
        }
        else {
            irParaTelaFrases()
        }
    }

    fun irParaTelaFrases(){
        // para navegar para a tela_frases
        startActivity(Intent(this, tela_frases::class.java))
    }
}
