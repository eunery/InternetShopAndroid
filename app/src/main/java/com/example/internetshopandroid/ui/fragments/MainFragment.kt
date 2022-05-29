package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentMainBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.viewmodels.MainViewModel

class MainFragment:Fragment(
    R.layout.fragment_main
) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    private val viewModel by viewModels<MainViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setNavBar()
    }

    private fun setNavBar() {
        val navHost = childFragmentManager.findFragmentById(R.id.NE_FragmentHost) as NavHostFragment
        val navController = navHost.navController
        NavigationUI.setupWithNavController(binding.navMenu, navController)
    }

}