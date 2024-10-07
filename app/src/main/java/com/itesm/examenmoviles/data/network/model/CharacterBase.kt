package com.itesm.examenmoviles.data.network.model

import com.google.gson.annotations.SerializedName
import com.itesm.examenmoviles.data.network.model.DragonBall.OriginPlanet
import com.itesm.examenmoviles.data.network.model.DragonBall.Transformation

data class CharacterBase(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("ki") val ki: String,
    @SerializedName("maxKi") val max_ki: String,
    @SerializedName("race") val race: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("affiliation") val affiliation: String,
    @SerializedName("originPlanet") val originPlanet: OriginPlanet,
    @SerializedName("transformations") val transformations: List<Transformation>
)
