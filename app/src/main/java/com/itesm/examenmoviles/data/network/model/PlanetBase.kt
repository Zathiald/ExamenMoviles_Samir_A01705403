package com.itesm.examenmoviles.data.network.model

import com.google.gson.annotations.SerializedName

data class OriginPlanet(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String // Asegúrate de que la API devuelve la imagen
)
