package com.aprouxdev.marvelapp.network.services

import com.aprouxdev.marvelapp.network.Constants
import com.aprouxdev.marvelapp.pojo.MarvelCharacter
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {


    @GET(Constants.MARVEL_PATH_AUTH)
    fun getMarvelCharacters() : Call<List<MarvelCharacter>>
}