package com.example.internetshopandroid.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.MainActivity
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentProfileBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.setToolbarTitle
import com.example.internetshopandroid.viewmodels.ProfileViewModel

class ProfileFragment:Fragment(
    R.layout.fragment_profile
) {
    private val binding by viewBinding(FragmentProfileBinding::bind)

    private val viewModel by viewModels<ProfileViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle(requireContext().getString(R.string.nav_menu_profile))
        binding.profileLogoutBtn.setOnClickListener {
            viewModel.logout()
            toLoginPage()
        }
    }

    private fun toLoginPage() {
        requireActivity().apply {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}