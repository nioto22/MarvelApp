package com.aprouxdev.marvelapp.network.services

import com.aprouxdev.marvelapp.network.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var retrofit : Retrofit =  Retrofit.Builder()
        .baseUrl(Constants.MARVEL_BASE_URL)
        .addConverterFactory((GsonConverterFactory.create()))
        .build()

    fun <S> createService(serviceClass: Class<S>): S{
        return retrofit.create(serviceClass)
    }
}