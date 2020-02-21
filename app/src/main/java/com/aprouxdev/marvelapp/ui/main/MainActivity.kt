package com.aprouxdev.marvelapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aprouxdev.marvelapp.R
import com.aprouxdev.marvelapp.pojo.MarvelCharacter

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    private var recyclerview: RecyclerView? = null
    private lateinit var adapter: CharacterRecyclerAdapter

    private var characterList = ArrayList<MarvelCharacter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        setupRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.getCharacters().observe(this, Observer {
            for (character in it){
                characterList.add(character)
            }
            adapter.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerView() {
        recyclerview = findViewById(R.id.main_characters_recyclerview)
        recyclerview!!.layoutManager = GridLayoutManager(this, 3)
        adapter = CharacterRecyclerAdapter(characterList)
        recyclerview!!.adapter = adapter

    }
}
