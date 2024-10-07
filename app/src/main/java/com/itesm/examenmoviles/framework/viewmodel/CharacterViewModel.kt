package com.itesm.examenmoviles.framework.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itesm.examenmoviles.data.network.model.DragonBall.CharacterList
import com.itesm.examenmoviles.data.network.model.CharacterObject
import com.itesm.examenmoviles.domain.DragonListRequirement
import com.itesm.examenmoviles.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CharacterViewModel : ViewModel() {

    val dragonObjectLiveData = MutableLiveData<CharacterObject?>()
    private val dragonListRequirement = DragonListRequirement()

    fun getDragonList() {
        viewModelScope.launch {
            try {
                // Llama al método para obtener la lista de dragones
                val result: CharacterObject? = dragonListRequirement(Constants.MAX_DRAGON_NUMBER)

                // Verifica si el resultado es nulo
                if (result != null) {
                    // Loguea el resultado obtenido
                    Log.d("CharacterViewModel", "Dragon List: ${result}") // O usa ${result.toString()} si necesitas una representación específica
                    dragonObjectLiveData.postValue(result)
                } else {
                    Log.e("CharacterViewModel", "Failed to fetch dragon list: result is null")
                }
            } catch (e: HttpException) {
                // Loguea el error HTTP
                Log.e("CharacterViewModel", "HTTP error: ${e.code()} - ${e.message()}")
                e.response()?.errorBody()?.let { errorBody ->
                    Log.e("CharacterViewModel", "Error body: ${errorBody.string()}")
                }
            } catch (e: Exception) {
                // Loguea cualquier otro error
                Log.e("CharacterViewModel", "Error fetching dragon list: ${e.localizedMessage}")
            }
        }
    }


}
