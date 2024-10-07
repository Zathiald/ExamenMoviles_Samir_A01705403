package com.itesm.examenmoviles.framework.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList
import com.itesm.examenmoviles.data.network.model.CharacterObject
import com.itesm.examenmoviles.domain.DragonInfoRequirement
import com.itesm.examenmoviles.domain.DragonListRequirement
import com.itesm.examenmoviles.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CharacterViewModel : ViewModel() {

    val dragonObjectLiveData = MutableLiveData<CharacterObject?>()
    private val dragonListRequirement = DragonListRequirement()
    private val dragonInfoRequirement = DragonInfoRequirement()

    fun getDragonList() {
        viewModelScope.launch {
            try {
                // Llama al método para obtener la lista de dragones
                val result: CharacterObject? = dragonListRequirement(Constants.MAX_DRAGON_NUMBER)

                // Verifica si el resultado es nulo
                if (result != null) {

                    // Crea una nueva lista de personajes, obteniendo información adicional
                    val updatedItems = result.items.map { character ->
                        // Llama a dragonInfoRequirement para obtener detalles adicionales del personaje
                        val characterWithPlanet = dragonInfoRequirement(character.id)

                        // Si obtenemos detalles adicionales, usamos characterWithPlanet, de lo contrario mantenemos el original
                        characterWithPlanet ?: character
                    }

                    // Asigna la nueva lista de personajes a result
                    result.items = updatedItems

                    // Actualiza el LiveData con la lista modificada
                    dragonObjectLiveData.postValue(result)
                } else {
                    Log.e("CharacterViewModel", "Failed to fetch dragon list: result is null")
                }
            } catch (e: HttpException) {
                // Loguea el error HTTP
                Log.e("CharacterViewModel", "HTTP error: ${e.code()} - ${e.message()}")
            } catch (e: Exception) {
                // Loguea cualquier otro error
                Log.e("CharacterViewModel", "Error fetching dragon list: ${e.localizedMessage}")
            }
        }
    }
}

