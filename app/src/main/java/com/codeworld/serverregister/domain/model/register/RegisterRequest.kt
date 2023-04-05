package com.codeworld.serverregister.domain.model.register

data class RegisterRequest(
    var email: String? = null,
    var date: String? = null,
    var lastName: String? = null,
    var gender: String? = null,
    var avatarUrl: String? = null,
    var isAdmin: Boolean? = null,
    var login: String? = null,
    var firstName: String? = null,
    var password: String? = null,
)