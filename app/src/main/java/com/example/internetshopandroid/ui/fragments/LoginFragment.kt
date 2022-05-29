package com.example.internetshopandroid.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.internetshopandroid.R
import com.example.internetshopandroid.databinding.FragmentHomeBinding
import com.example.internetshopandroid.databinding.FragmentLoginBinding
import com.example.internetshopandroid.findAppComponent
import com.example.internetshopandroid.viewmodels.CartViewModel
import com.example.internetshopandroid.viewmodels.LoginViewModel

class LoginFragment :Fragment(
    R.layout.fragment_login
) {
    private val binding by viewBinding(FragmentLoginBinding::bind)

    private val viewModel by viewModels<LoginViewModel> {
        requireContext().findAppComponent().viewModelFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginEnterBtn.setOnClickListener{
            val login = binding.loginFieldUsername.text
            val password = binding.loginFieldPassword.text
            viewModel.login(login.toString(), password.toString())
        }
        binding.loginFieldUsername.setOnFocusChangeListener { view, b ->
            if (b == true){
                binding.loginMessageError.text = ""
            }
        }
        binding.loginFieldPassword.setOnFocusChangeListener { view, b ->
            if (b == true){
                binding.loginMessageError.text = ""
            }
        }
        viewModel.isLoggedIn.observe(viewLifecycleOwner){
            if (it) {
                toMainPage()
            }
        }
        viewModel.errorMessage.observe(viewLifecycleOwner){
            binding.loginMessageError.isVisible = it != null
            when (it) {
                "notFound" -> {
                    binding.loginMessageError.text = "Данный пользователь отсутствует"
                }
                "wrongPassword" -> {
                    binding.loginMessageError.text = "Неправильный пароль"
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.checkLogin()
    }

    private fun toMainPage() =
        findNavController().navigate(
            R.id.action_loginFragment_to_mainFragment2
        )
}