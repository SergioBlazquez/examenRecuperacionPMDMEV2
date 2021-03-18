package com.example.prueba

import com.google.gson.annotations.SerializedName


data class People(

    var name: String,
    var birth_year: String,
    var eye_color: String,
    var gender: String,
    var hair_color: String,
    var height: String,
    var mass: String,
    var skin_color: String,
    var homeworld: String,
    var films: List<String>?,
    //var species: List<String>?,
    @SerializedName("species") val speciesUrls: List<String>?,
    var starships: List<String>?,
    var vehicles: List<String>?,
    var url: String,
    var created: String,
    var edited: String,
    var title: String,){

override fun toString(): String {
    //return "$title, directed by $director in $created\n"



    return " $name pertenece a la raza $speciesUrls \n"
}
}


