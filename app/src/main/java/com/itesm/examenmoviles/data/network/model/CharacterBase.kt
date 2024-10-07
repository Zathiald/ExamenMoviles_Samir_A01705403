package com.itesm.examenmoviles.data.network.model

import com.google.gson.annotations.SerializedName

data class CharacterBase(
    @SerializedName("id") val id: Int,  // Agregado para el ID
    @SerializedName("name") val name: String,
    @SerializedName("ki") val ki: String,
    @SerializedName("maxKi") val max_ki: String, // Cambia el nombre de la variable para que coincida con la API
    @SerializedName("race") val race: String,
    @SerializedName("gender") val gender: String,  // Agregado para el género
    @SerializedName("description") val description: String,  // Agregado para la descripción
    @SerializedName("image") val image: String,  // Agregado para la imagen
    @SerializedName("affiliation") val affiliation: String // Agregado para la afiliación
)
