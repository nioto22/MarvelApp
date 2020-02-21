package com.aprouxdev.marvelapp.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aprouxdev.marvelapp.R
import com.aprouxdev.marvelapp.inflate
import com.aprouxdev.marvelapp.pojo.MarvelCharacter
import com.aprouxdev.marvelapp.ui.detail.DetailActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_character_item.view.*

class CharacterRecyclerAdapter(private val characters: List<MarvelCharacter>): RecyclerView.Adapter<CharacterRecyclerAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        //val inflatedView = parent.inflate(R.layout.layout_character_item, false)
        val inflatedView = parent.inflate(R.layout.layout_character_item, false)
        return CharacterViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int
    ) {
        val character = characters[position]
        holder.bindCharacter(character)
    }


    // VIEW HOLDER
    class CharacterViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var character: MarvelCharacter? = null


        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            val context = itemView.context
            val goToDetailActivityIntent = Intent(context, DetailActivity::class.java)
            goToDetailActivityIntent.putExtra(CHARACTER_KEY, character)
            context.startActivity(goToDetailActivityIntent)
        }

        fun bindCharacter(character: MarvelCharacter) {
            this.character = character
            val imagePath: String = character.thumbnail.getUrl()
            Picasso.get().load(imagePath).resize(240, 240).centerCrop().into(view.itemImage)
            view.itemTitle.text = character.name
        }

        companion object {
            private val CHARACTER_KEY = "CHARACTER_KEY"
        }

    }
}