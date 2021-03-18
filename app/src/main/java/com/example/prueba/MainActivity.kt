package com.example.prueba

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.util.*

interface MainActivityInterface {



    suspend fun onPeopleReceived(listPeople: List<People>)
}

 class MainActivity : AppCompatActivity(), MainActivityInterface,
     AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    var listaDatos: ArrayList<String>? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        lifecycleScope.launch(Dispatchers.IO){
            GetAllFilms.send(this@MainActivity)
        }


        val spinner: Spinner =findViewById(R.id.spinner)

        spinner.onItemSelectedListener=this

       ArrayAdapter.createFromResource(this, R.array.generos,R.layout.activity_main)


        // Comento lo que me da error

        //val exampleList= onPeopleReceived(listPeople) --> Al crear la variable no me deja pasarle la lista de las Personas(personajes Star Wars)
        val recycler_view: RecyclerView =findViewById(R.id.recyclerView)


        //recycler_view.adapter=Adapter(exampleList) --> Al no dejarme pasar la lista de las personas me da un error al poner exampleList aquí
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    override suspend fun onPeopleReceived(listPeople: List<People>) {
        withContext(Dispatchers.Main){
            binding.textView.text = ""
            listPeople.forEach {

                //dependiendo de la posicion del spinner, filtrar si es hombre --> si es hombre, si es mujer --> mujer, si es otros --> si no es ni mujer ni hombre, si es todos no entra en el if

                binding.textView.append(it.toString())
            }
        }

    }

     override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
         TODO("Not yet implemented")
     }

     override fun onNothingSelected(parent: AdapterView<*>?) {
         TODO("Not yet implemented")
     }


 }