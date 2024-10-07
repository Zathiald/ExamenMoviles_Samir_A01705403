package com.itesm.examenmoviles.data.network.model

import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter

class DragonApiClient {
    private lateinit var api: DragonApiService

    // Ajustamos la función para devolver un Character que tiene una lista de Items
    suspend fun getDragonList(page: Int, limit: Int): CharacterList? {
        api = NetworkModuleDI()
        return try {
            api.getCharacterList(page, limit)  // Llamada con parámetros page y limit
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterById(id: Int): DragonBallCharacter? {
        api = NetworkModuleDI()
        return try {
            api.getCharacterById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

