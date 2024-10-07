package com.itesm.examenmoviles.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
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
    private lateinit var data: ArrayList<CharacterBase>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDragonBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Inicializar el ViewModel
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]
        data = ArrayList()

        initializeComponents() // No es necesario pasar root
        initializeObservers()
        viewModel.getDragonList()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents() {
        recyclerView = binding.RVDragon // Usa el binding para acceder al RecyclerView
        adapter = CharacterAdapter(emptyList(), requireContext()) // Ahora lo inicializas aquí
        recyclerView.adapter = adapter // Establecer el adapter aquí
        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.layoutManager = gridLayoutManager
    }

    private fun initializeObservers() {
        viewModel.dragonObjectLiveData.observe(viewLifecycleOwner) { characterObject ->
            if (characterObject != null) {
                setUpRecyclerView(characterObject.items)
            }
        }
    }

    private fun setUpRecyclerView(dataForList: List<CharacterBase>) {
        adapter.updateCharacters(dataForList) // Actualiza los datos en el adapter
    }
}

