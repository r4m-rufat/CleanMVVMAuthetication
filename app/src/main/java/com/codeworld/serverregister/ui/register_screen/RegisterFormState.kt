package com.codeworld.serverregister.ui.register_screen

/*
this data class holds the state of register fields
 */
data class RegisterFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val nameError: Int? = null,
    val phoneError: Int? = null,
    val isValid: Boolean = false
)
