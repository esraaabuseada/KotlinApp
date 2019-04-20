package com.example.esraa.kotlinapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val ROOT_URL = "https://gist.githubusercontent.com/"
    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): ApiResponce {
        return getRetrofitInstance().create<ApiResponce>(ApiResponce::class.java!!)
    }
}