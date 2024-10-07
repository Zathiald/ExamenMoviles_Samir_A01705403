package com.itesm.examenmoviles.data.network.model

import com.google.gson.annotations.SerializedName
import com.itesm.examenmoviles.data.network.model.DragonBall.Meta

data class CharacterObject(
    @SerializedName("items") val items: List<CharacterBase>,
    @SerializedName("meta") val meta: Meta
)


