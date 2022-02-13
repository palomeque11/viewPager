package com.example.viewpagertest.model.common

import com.example.viewpagertest.model.remote.BASE_URL
import com.example.viewpagertest.model.remote.SongsApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Network {
    val songsApi:SongsApi by lazy {
        initRetrofit().create(SongsApi::class.java)
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}