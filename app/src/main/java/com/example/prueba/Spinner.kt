package com.example.prueba

import android.app.Activity
import android.view.View
import android.widget.AdapterView

abstract class Spinner : Activity(), AdapterView.OnItemSelectedListener{


    public fun elegido(parent: AdapterView<*>, view: View, pos:Int, id:Int): Any? {

        val valorElegido=parent.getItemAtPosition(pos)

        return valorElegido
    }



}