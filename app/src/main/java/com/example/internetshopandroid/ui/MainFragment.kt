package com.example.internetshopandroid.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentMainBinding

class MainFragment:Fragment(
    R.layout.fragment_main
) {
    private val binding by viewBinding(FragmentMainBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.NE_FragmentHost) as NavHostFragment
        val navController = navHost.navController
        NavigationUI.setupWithNavController(binding.navMenu, navController)
    }


}