package com.codeworld.serverregister.di

import android.util.Log
import com.codeworld.serverregister.BuildConfig
import com.codeworld.serverregister.common.APP_DEBUG
import com.codeworld.serverregister.data.remote.api.ApiService
import com.codeworld.serverregister.data.repository.LoginRepository_Impl
import com.codeworld.serverregister.data.repository.RegisterRepository_Impl
import com.codeworld.serverregister.domain.repository.LoginRepository
import com.codeworld.serverregister.domain.repository.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApiService(client: OkHttpClient) = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .build()
        .create(ApiService::class.java)

    @Provides
    fun provideClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d(
                APP_DEBUG,
                "log: $message"
            )
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    }

    @Provides
    fun provideRegisterRepository(service: ApiService): RegisterRepository = RegisterRepository_Impl(service)

    @Provides
    fun provideLoginRepository(service: ApiService): LoginRepository = LoginRepository_Impl(service)


}