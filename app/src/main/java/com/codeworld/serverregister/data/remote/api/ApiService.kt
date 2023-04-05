package com.codeworld.serverregister.data.remote.api

import com.codeworld.serverregister.domain.model.login.LoginRequest
import com.codeworld.serverregister.domain.model.login.LoginResponse
import com.codeworld.serverregister.domain.model.register.RegisterRequest
import com.codeworld.serverregister.domain.model.register.RegisterResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("customers/login")
    fun login(@Body loginRequest: LoginRequest): Observable<LoginResponse>

    @POST("customers")
    fun register(@Body registerRequest: RegisterRequest): Observable<RegisterResponse>


}