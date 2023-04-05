package com.codeworld.serverregister.data.repository

import com.codeworld.serverregister.data.remote.api.ApiService
import com.codeworld.serverregister.domain.model.login.LoginRequest
import com.codeworld.serverregister.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepository_Impl @Inject constructor(
    private val apiService: ApiService
): LoginRepository {

    override fun login(loginRequest: LoginRequest) = apiService.login(loginRequest)

}