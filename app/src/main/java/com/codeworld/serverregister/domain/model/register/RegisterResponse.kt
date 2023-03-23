package com.codeworld.serverregister.domain.model.register

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    val firstName: String,
    val lastName: String,
    val login: String,
    val email: String,
    val password: String,
    val telephone: String,
    val gender: String,
    val avatarUrl: String,
    val isAdmin: Boolean,
    val enabled: Boolean,
    val customerNo: String,
    val date: String,
    @SerializedName("__v")
    val version: String
)