package com.codeworld.serverregister.common

import android.util.Patterns

fun isValidUsername(username: String) = Patterns.EMAIL_ADDRESS.matcher(username).matches()

fun isValidPassword(password: String) = password.length >= 6

