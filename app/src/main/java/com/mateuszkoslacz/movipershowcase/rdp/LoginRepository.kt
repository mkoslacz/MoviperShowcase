package com.mateuszkoslacz.movipershowcase.rdp

import com.mateuszkoslacz.movipershowcase.data.LoginBundle
import com.mateuszkoslacz.movipershowcase.data.UserModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

class LoginRepository {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()!!

    fun performLogin(loginBundle: LoginBundle): Single<UserModel> {
        return retrofit
                .create(LoginAndGetUser::class.java)
                .getUser(loginBundle.authorization)
    }

    private interface LoginAndGetUser {
        @GET("/user")
        fun getUser(@Header("Authorization") authorization: String): Single<UserModel>
    }
}