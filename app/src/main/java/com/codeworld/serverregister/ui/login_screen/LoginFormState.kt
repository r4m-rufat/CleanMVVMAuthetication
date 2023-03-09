package com.codeworld.serverregister.ui.login_screen

data class LoginFormState(
    var usernameError: Int? = null,
    var passwordError: Int? = null,
    var isValid: Boolean = false,
)
