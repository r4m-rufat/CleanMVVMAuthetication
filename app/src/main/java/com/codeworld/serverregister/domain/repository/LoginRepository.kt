package com.codeworld.serverregister.domain.repository

import com.codeworld.serverregister.domain.model.login.LoginRequest
import com.codeworld.serverregister.domain.model.login.LoginResponse
import io.reactivex.Observable

interface LoginRepository {

    fun login(loginRequest: LoginRequest): Observable<LoginResponse>

}