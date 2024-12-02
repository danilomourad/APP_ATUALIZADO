package com.example.barbeariaestudiow


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.barbeariaestudiow.databinding.ActivityMainBinding
import com.example.barbeariaestudiow.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)

                // Configurando o binding com o layout
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

                // Habilitando a borda estendida
                enableEdgeToEdge()

                // Ocultando a ActionBar
                supportActionBar?.hide()

                // Configurando o botão de login
                binding.btLogin.setOnClickListener {
                        val nome = binding.editNome.text.toString()
                        val senha = binding.editSenha.text.toString()

                        when {
                                nome.isEmpty() -> mensagem(it, "Por favor, insira seu nome!")
                                senha.isEmpty() -> mensagem(it, "Por favor, insira sua senha!")
                                senha.length <=5 -> mensagem(it, "A senha precisa ter pelo menos 6 caracteres")
                                else -> {
                                val intent = Intent(this, Home::class.java)
                                startActivity(intent)
                                finish() // Finaliza a MainActivity para evitar voltar com o botão "Voltar"
                        }
                        }
                }

                // Ajustando paddings para considerar barras do sistema
                ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
                        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                        view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                        insets
                }
        }

        private fun mensagem(view: View, mensagem: String) {
                val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.parseColor("#FF0000")) // Vermelho
                snackbar.setTextColor(Color.parseColor("#FFFFFF")) // Branco
                snackbar.show()
        }

        private fun enableEdgeToEdge() {
                window.decorView.systemUiVisibility =
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
}
