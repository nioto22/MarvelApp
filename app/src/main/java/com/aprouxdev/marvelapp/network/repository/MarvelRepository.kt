package com.aprouxdev.marvelapp.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aprouxdev.marvelapp.network.services.MarvelApi
import com.aprouxdev.marvelapp.network.services.RetrofitService
import com.aprouxdev.marvelapp.pojo.MarvelCharacter
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MarvelRepository {

    var client: MarvelApi = RetrofitService.createService(MarvelApi::class.java)

    fun getCharacters(): LiveData<List<MarvelCharacter>> {
        val liveData = MutableLiveData<List<MarvelCharacter>>()

        client.getMarvelCharacters().enqueue(object : Callback<List<MarvelCharacter>> {
            override fun onResponse(call: Call<List<MarvelCharacter>>, response: Response<List<MarvelCharacter>>) {
                if (response.isSuccessful){
                    liveData.value = response.body()
                }
            }
            override fun onFailure(call: Call<List<MarvelCharacter>>, t: Throwable) {
                error("Get characters fail")
                t.printStackTrace()
            }
        })
        return liveData
    }

}