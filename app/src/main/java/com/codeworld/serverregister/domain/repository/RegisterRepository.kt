package com.codeworld.serverregister.domain.repository

import com.codeworld.serverregister.domain.model.register.RegisterRequest
import com.codeworld.serverregister.domain.model.register.RegisterResponse
import io.reactivex.Observable

interface RegisterRepository {

    fun register(registerRequest: RegisterRequest): Observable<RegisterResponse>

}