package com.codeworld.serverregister.domain.use_case

import com.codeworld.serverregister.domain.model.register.RegisterRequest
import com.codeworld.serverregister.domain.model.register.RegisterResponse
import com.codeworld.serverregister.domain.repository.RegisterRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: RegisterRepository
) {

    fun execute(request: RegisterRequest): Observable<RegisterResponse> {

        return repository.register(request).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io())

    }

}