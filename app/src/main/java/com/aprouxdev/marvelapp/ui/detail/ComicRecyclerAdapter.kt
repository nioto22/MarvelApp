package com.aprouxdev.marvelapp.ui.detail

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aprouxdev.marvelapp.R
import com.aprouxdev.marvelapp.inflate
import com.aprouxdev.marvelapp.pojo.ComicItem
import kotlinx.android.synthetic.main.layout_comic_item.view.*

class ComicRecyclerAdapter(private val comics: List<ComicItem>): RecyclerView.Adapter<ComicRecyclerAdapter.CharacterViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        //val inflatedView = parent.inflate(R.layout.layout_character_item, false)
        val inflatedView = parent.inflate(R.layout.layout_comic_item, false)
        return CharacterViewHolder(inflatedView)

    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int
    ) {
        val comic = comics[position]
        holder.bindCharacter(comic)
    }

    class CharacterViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var comic: ComicItem? = null


        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            // TODO on click comic. Not implemented
        }

        fun bindCharacter(comic: ComicItem) {
            this.comic = comic
            view.tvComicItemName.text = comic.name
        }

    }


}