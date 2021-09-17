package com.aprouxdev.marvelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aprouxdev.marvelapp.network.repository.MarvelRepository
import com.aprouxdev.marvelapp.pojo.MarvelCharacter

class MainViewModel : ViewModel() {

    companion object {
        const val RANDOM_FIRST_COUNT = 22
    }
    private val repository: MarvelRepository = MarvelRepository()

    fun getCharacters(): LiveData<List<MarvelCharacter>> {
        return repository.getCharacters()
    }


    fun getRandomCharacters() {

    }

}