package com.itesm.examenmoviles.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itesm.examenmoviles.R
import com.itesm.examenmoviles.data.network.model.CharacterBase
import com.itesm.examenmoviles.databinding.FragmentDragonBinding
import com.itesm.examenmoviles.framework.adapters.CharacterAdapter
import com.itesm.examenmoviles.framework.viewmodel.CharacterViewModel

class CharacterFragment : Fragment() {
    private var _binding: FragmentDragonBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter
    private var data: List<CharacterBase> = emptyList()
    private var filteredData: List<CharacterBase> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDragonBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializar el ViewModel
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        initializeComponents()
        initializeObservers()
        viewModel.getDragonList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents() {
        recyclerView = binding.RVDragon
        adapter = CharacterAdapter(emptyList(), requireContext())
        recyclerView.adapter = adapter
        // Cambia el GridLayoutManager por LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        setupRaceSpinner()
    }

    private fun setupRaceSpinner() {
        val races = listOf("All", "Saiyan", "Human", "Namekian", "Android", "Frieza Race", "Majin", "God", "Angel", "Unknown", "Jiren Race", "Nucleico", "Evil")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, races)
        binding.spinnerRaza.adapter = adapter
        binding.spinnerRaza.setSelection(0) // Predeterminado en "Todas"

        binding.spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                filterCharacters(races[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun initializeObservers() {
        viewModel.dragonObjectLiveData.observe(viewLifecycleOwner) { characterObject ->
            if (characterObject != null) {
                data = characterObject.items // Almacena los datos originales
                setUpRecyclerView(data)
            }
        }
    }

    private fun setUpRecyclerView(dataForList: List<CharacterBase>) {
        adapter.updateCharacters(dataForList) // Actualiza los datos en el adapter
    }

    private fun filterCharacters(selectedRace: String) {
        filteredData = if (selectedRace == "Todas") {
            data // Muestra todos los personajes
        } else {
            data.filter { it.race == selectedRace } // Filtra por raza seleccionada
        }
        setUpRecyclerView(filteredData) // Actualiza el RecyclerView con los personajes filtrados
    }
}
