package com.codeworld.serverregister.data.repository

import com.codeworld.serverregister.data.remote.api.ApiService
import com.codeworld.serverregister.domain.model.register.RegisterRequest
import com.codeworld.serverregister.domain.repository.RegisterRepository
import javax.inject.Inject

class RegisterRepository_Impl @Inject constructor(
    private val apiService: ApiService
): RegisterRepository {

    override fun register(registerRequest: RegisterRequest) = apiService.register(registerRequest)
}