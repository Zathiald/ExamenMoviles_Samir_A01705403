package com.itesm.examenmoviles.data.network.model

import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter

class DragonApiClient {
    private lateinit var api: DragonApiService

    // Ajustamos la función para devolver un Character que tiene una lista de Items
    suspend fun getDragonList(limit: Int): CharacterObject? {
        api = NetworkModuleDI()
        return try {
            api.getCharacterList(limit)  // Llamada con parámetros page y limit
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    suspend fun getCharacterById(id: Int): CharacterBase? {
        api = NetworkModuleDI()
        return try {
            api.getCharacterById(id)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}

