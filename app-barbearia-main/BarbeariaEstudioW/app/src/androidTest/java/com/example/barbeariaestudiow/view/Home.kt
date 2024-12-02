package com.example.barbeariaestudiow.view


import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barbeariaestudiow.R
import com.example.barbeariaestudiow.adapter.ServicosAdapter
import com.example.barbeariaestudiow.databinding.ActivityHomeBinding
import com.example.barbeariaestudiow.model.Servicos


class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val name = intent.extras?.getString("name")
        binding.txtTServiOs.text = "bem-vindo(a),$name"


        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this, listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos.adapter = servicosAdapter
        getServicos()

        binding.btgAgendar.setOnClickListener {
            val intent = Intent (this,Agendamento::class.java)
            intent.putExtra("nome",name)
            startActivity(intent)
        }


        }


    private fun getServicos(){

        val servico1 = Servicos(R.drawable.img1, "Degradê")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Cabelo + Barba")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.img3, "Social")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.img4, "Barba")
        listaServicos.add(servico4)

        val servico5 = Servicos(R.drawable.img5, "Sombrancelha")
        listaServicos.add(servico5)
    }
}