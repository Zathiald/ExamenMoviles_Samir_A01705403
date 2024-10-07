package com.itesm.examenmoviles.data

import com.itesm.examenmoviles.data.network.model.CharacterBase
import com.itesm.examenmoviles.data.network.model.CharacterObject
import com.itesm.examenmoviles.data.network.model.DragonApiClient
import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter

class DragonRepository() {
    private val apiCharacter = DragonApiClient()

    // Función para obtener la lista de personajes paginada
    suspend fun getCharacterList(limit: Int): CharacterObject? {
        return apiCharacter.getDragonList(limit)
    }

    suspend fun getCharacterById(id: Int): CharacterBase? {
        return apiCharacter.getCharacterById(id)
    }
}
