package com.aprouxdev.marvelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aprouxdev.marvelapp.network.repository.MarvelRepository
import com.aprouxdev.marvelapp.pojo.MarvelCharacter

class MainViewModel : ViewModel() {

    private val repository: MarvelRepository = MarvelRepository()

    fun getCharacters(): LiveData<List<MarvelCharacter>> {
        return repository.getCharacters()
    }
}