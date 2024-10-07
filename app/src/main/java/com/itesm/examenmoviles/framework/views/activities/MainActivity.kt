package com.itesm.examenmoviles.framework.views.activities

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.itesm.examenmoviles.R
import com.itesm.examenmoviles.databinding.ActivityMainBinding
import com.itesm.examenmoviles.framework.viewmodel.MainViewModel
import com.itesm.examenmoviles.framework.views.fragments.CharacterFragment

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var currentFragment: Fragment

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        exchangeCurrentFragment(CharacterFragment())

    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initializeObservers(){

    }

    private fun exchangeCurrentFragment(newFragment: Fragment){
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main,currentFragment)
            .commit()
    }
}