package com.example.data.repository

import com.example.network.retrofit.ITokenProvider
import com.example.data.storage.IStorage
import com.example.domain.model.LoginArgs
import com.example.domain.repository.IAuthRepo
import com.example.domain.repository.LoginResult
import com.example.network.retrofit.ApiProvider
import javax.inject.Inject

class AuthRepo @Inject constructor(
    private val apiProvider: ApiProvider,
    private val storage: IStorage
): IAuthRepo {
    override suspend fun login(args: LoginArgs): LoginResult {
        val response = apiProvider.getApi().login(args)
        if (response.code() == 404) {
            return LoginResult.error("notFound")
        } else if (response.code() == 422){
            return LoginResult.error("wrongPassword")
        }
        val data = response.body()!!
        return if(data.status == "success"){
            storage.saveAccessToken(data.data!!.access)
            storage.saveRefreshToken(data.data!!.refresh)
            LoginResult.success
        }
        else {
            LoginResult.error(data.text!!)
        }

    }

    override suspend fun logout() {
        storage.saveAccessToken(null)
        storage.saveRefreshToken(null)
    }

    override suspend fun check(): Boolean {
        return storage.getAccessToken() != null
    }
}