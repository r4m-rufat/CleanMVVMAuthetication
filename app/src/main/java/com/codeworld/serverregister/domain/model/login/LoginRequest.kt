package com.codeworld.serverregister.domain.model.login

data class LoginRequest(
    val loginOrEmail: String,
    val password: String
)