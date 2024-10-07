package com.itesm.examenmoviles.domain

import com.itesm.examenmoviles.data.DragonRepository
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter

class DragonInfoRequirement {

    // Instancia del repositorio que gestiona la API y los datos
    private val repository = DragonRepository()

    suspend operator fun invoke(id: Int): DragonBallCharacter? {
        return repository.getCharacterById(id)
    }
}