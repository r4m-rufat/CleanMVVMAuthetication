package com.codeworld.serverregister.data.remote.api

import com.codeworld.serverregister.common.AUTHORIZATION_HEADER
import okhttp3.OkHttpClient
import javax.inject.Inject

class ApiAuthenticator @Inject constructor(private val okHttpClient: OkHttpClient) {

    fun setAuthToken(token: String) {

        val interceptor = okHttpClient.interceptors
        val modifiedInterceptor = interceptor.toMutableList()

        modifiedInterceptor.add {chain ->

            val request = chain.request().newBuilder()
                .addHeader(AUTHORIZATION_HEADER, token)
                .build()

            return@add chain.proceed(request)

        }

    }

}