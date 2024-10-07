package com.itesm.examenmoviles.domain


import com.itesm.examenmoviles.data.DragonRepository
import com.itesm.examenmoviles.data.network.model.CharacterObject
import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList

class DragonListRequirement {

    // Instancia del repositorio que gestiona la API y los datos
    private val repository = DragonRepository()

    // Sobrecargamos el operador 'invoke' para usarlo como si fuera una función
    suspend operator fun invoke(
        limit: Int  // Límite de resultados por página
    ): CharacterObject? = repository.getCharacterList(limit)
}
