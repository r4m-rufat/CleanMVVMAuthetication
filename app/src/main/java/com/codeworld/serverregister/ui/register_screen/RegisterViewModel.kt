package com.codeworld.serverregister.ui.register_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codeworld.serverregister.R
import com.codeworld.serverregister.common.APP_DEBUG
import com.codeworld.serverregister.common.ApiResult
import com.codeworld.serverregister.common.isValidPassword
import com.codeworld.serverregister.common.isValidUsername
import com.codeworld.serverregister.domain.use_case.RegisterUseCase
import com.codeworld.serverregister.domain.model.register.RegisterRequest
import com.codeworld.serverregister.domain.model.register.RegisterResponse
import com.codeworld.serverregister.ui.login_screen.LoginFormState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCase: RegisterUseCase
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val _registerState = MutableLiveData<ApiResult<RegisterResponse>>(null)
    val registerState
        get() = _registerState as LiveData<ApiResult<RegisterResponse>>

    private val _registerFormState = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerFormState

    fun registerUser(request: RegisterRequest) =
        useCase.execute(request).subscribe(object : Observer<RegisterResponse> {

            override fun onSubscribe(d: Disposable) {
                compositeDisposable.add(d)
            }

            override fun onNext(t: RegisterResponse) {
                _registerState.value = ApiResult.Success(t)
            }

            override fun onError(e: Throwable) {
                _registerState.value = ApiResult.Error(e)
            }

            override fun onComplete() {
                Log.d(APP_DEBUG, "onComplete: Task is finished")
            }
        })

    fun registerStateChanged(request: RegisterRequest) {

        if (!isValidUsername(request.email!!)) {
            _registerFormState.value = RegisterFormState(usernameError = R.string.not_valid_email)
        } else if (!isValidPassword(request.password!!)) {
            _registerFormState.value = RegisterFormState(passwordError = R.string.invalid_password)
        }else {
            _registerFormState.value = RegisterFormState(isValid = true)
        }

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}