package com.example.internetshopandroid.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentHomeBinding
import com.example.internetshopandroid.databinding.FragmentSignupBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.example.internetshopandroid.viewmodels.SearchViewModel

class SignUpFragment: Fragment(
    R.layout.fragment_signup
) {
    private val binding by viewBinding(FragmentSignupBinding::bind)

    private val viewModel by viewModels<SearchViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

}