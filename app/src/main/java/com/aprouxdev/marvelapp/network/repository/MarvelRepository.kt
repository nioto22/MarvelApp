package com.aprouxdev.marvelapp.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aprouxdev.marvelapp.network.services.MarvelApi
import com.aprouxdev.marvelapp.network.services.RetrofitService
import com.aprouxdev.marvelapp.pojo.MarvelCharacter
import com.aprouxdev.marvelapp.pojo.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MarvelRepository {

    var client: MarvelApi = RetrofitService.createService(MarvelApi::class.java)

    fun getCharacters(): LiveData<List<MarvelCharacter>> {
        val liveData = MutableLiveData<List<MarvelCharacter>>()

        client.getMarvelCharacters().enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.isSuccessful){
                    val responseApi: Result = response.body()!!
                    liveData.value = responseApi.data.results

                }
            }
            override fun onFailure(call: Call<Result>, t: Throwable) {
               t.printStackTrace()
            }

        })
        return liveData
    }

}