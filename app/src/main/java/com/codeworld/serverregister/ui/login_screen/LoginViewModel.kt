package com.codeworld.serverregister.ui.login_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codeworld.serverregister.R
import com.codeworld.serverregister.common.isValidPassword
import com.codeworld.serverregister.common.isValidUsername
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _loginFormState = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginFormState

    fun loginStateChanged(username: String, password: String) {

        if (!isValidUsername(username)) {
            _loginFormState.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isValidPassword(password)) {
            _loginFormState.value = LoginFormState(passwordError = R.string.invalid_password)
        }else {
            _loginFormState.value = LoginFormState(isValid = true)
        }

    }

}