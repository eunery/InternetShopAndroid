package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCases.LoginUseCase.ILoginUseCase
import com.example.domain.useCases.LogoutUseCase.LogoutUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val logoutUseCase: LogoutUseCase
): ViewModel() {

    fun logout(){
        viewModelScope.launch {
            logoutUseCase.logout()
        }
    }
}