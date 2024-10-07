package com.itesm.examenmoviles.framework.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itesm.examenmoviles.data.network.model.CharacterBase
import com.itesm.examenmoviles.data.network.model.DragonBall.DragonBallCharacter
import com.itesm.examenmoviles.databinding.ItemCharacterBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterBase, context: Context) {
        // Asigna los valores de los atributos del personaje a los TextViews correspondientes
        binding.TVName.text = "Name: " + character.name // Nombre
        binding.TVRace.text = "Race: " + character.race // Raza
        binding.TVKi.text = "Ki: " + character.ki.toString() // Ki
        binding.TVMaxKi.text = "Max Ki: " + character.max_ki.toString() // Max Ki
        binding.TVGender.text = "Gender: " + character.gender.toString()
        binding.TVAffiliation.text = "Affiliation: " + character.affiliation.toString()
        binding.TVDescription.text = character.description.toString()

        // Cargar la imagen usando Glide (o cualquier otra librería de tu elección)
        Glide.with(context)
            .load(character.image) // Suponiendo que `imageUrl` es la URL de la imagen
            .into(binding.IVPhoto)
    }
}
