package com.example.internetshopandroid.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.LoginArgs
import com.example.domain.repository.LoginResult
import com.example.domain.useCases.CheckLoginUseCase.ICheckLoginUseCase
import com.example.domain.useCases.LoginUseCase.ILoginUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: ILoginUseCase,
    private val checkLoginUseCase: ICheckLoginUseCase,
): ViewModel() {
    val isLoggedIn = MutableLiveData(false)
    val errorMessage = MutableLiveData<String?>()

    fun checkLogin() {
        viewModelScope.launch {
            isLoggedIn.value = checkLoginUseCase.check()
        }
    }

    fun login(login: String, password: String){
        viewModelScope.launch(
            CoroutineExceptionHandler { context, t ->
                t.printStackTrace()
                errorMessage.value = "unknown error"
            }
        ) {
            val result = loginUseCase.login(LoginArgs(
                username = login,
                password = password,
            ))
            when (result) {
                LoginResult.success -> isLoggedIn.value = true
                is LoginResult.error -> errorMessage.value = result.text
            }
        }
    }
}