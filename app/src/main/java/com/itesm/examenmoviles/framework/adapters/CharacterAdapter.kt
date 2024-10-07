package com.itesm.examenmoviles.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itesm.examenmoviles.data.network.model.CharacterBase
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter
import com.itesm.examenmoviles.databinding.ItemCharacterBinding
import com.itesm.examenmoviles.framework.adapters.viewholders.CharacterViewHolder

class CharacterAdapter(
    private var data: List<CharacterBase>, // Cambiado a List para mayor flexibilidad
    private val context: Context // Usando 'val' para el contexto
) : RecyclerView.Adapter<CharacterViewHolder>() {

    // Constructor primario que ya se utiliza
    // No es necesario tener un constructor secundario

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    // Método para actualizar la lista si es necesario
    fun updateCharacters(newCharacters: List<CharacterBase>) {
        data = newCharacters
        notifyDataSetChanged()
    }
}

