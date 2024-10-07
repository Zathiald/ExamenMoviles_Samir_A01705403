package com.itesm.examenmoviles.data

import com.itesm.examenmoviles.data.network.model.DragonApiClient
import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter

class DragonRepository() {
    private val apiCharacter = DragonApiClient()

    // Función para obtener la lista de personajes paginada
    suspend fun getCharacterList(page: Int, limit: Int): CharacterList? {
        return apiCharacter.getDragonList(page, limit)
    }

    suspend fun getCharacterById(id: Int): DragonBallCharacter? {
        return apiCharacter.getCharacterById(id)
    }
}
