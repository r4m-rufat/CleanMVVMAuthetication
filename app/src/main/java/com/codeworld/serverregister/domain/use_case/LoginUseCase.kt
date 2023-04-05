package com.codeworld.serverregister.domain.use_case

import com.codeworld.serverregister.domain.model.login.LoginRequest
import com.codeworld.serverregister.domain.model.login.LoginResponse
import com.codeworld.serverregister.domain.repository.LoginRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    fun execute(request: LoginRequest): Observable<LoginResponse> {
        return loginRepository.login(request).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())
    }

}