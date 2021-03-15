package com.example.prueba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val exampleList : List<ClaseItems>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.textView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ejemplo,parent,false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemActual = exampleList[position]
       //holder.textView.text= itemActual.text --> text es un variable dentro de MainActivity.kt

    }

    override fun getItemCount() = exampleList.size
}
