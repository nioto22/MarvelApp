package com.aprouxdev.marvelapp.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aprouxdev.marvelapp.R
import com.aprouxdev.marvelapp.pojo.ComicItem
import com.aprouxdev.marvelapp.pojo.MarvelCharacter
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    companion object {
        private val CHARACTER_KEY = "CHARACTER_KEY"
    }

    var character: MarvelCharacter? = null
    lateinit var comics: List<ComicItem>

    lateinit var image: ImageView
    lateinit var title: TextView
    lateinit var description: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var descriptionLayout: RelativeLayout
    lateinit var separator: View
    lateinit var noInformation: TextView
    private lateinit var comicsLayout: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupActionBar()
        getCharacterFromIntent()
        setupViews()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupActionBar() {
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun getCharacterFromIntent(){
        character = intent.getSerializableExtra(CHARACTER_KEY) as MarvelCharacter?
    }

    private fun setupViews(){
        initViews()

        setupTopViews()
        setupDescriptionViews()
        setupComicsViews()
        setupMissingDataViews()
    }

    private fun setupTopViews() {
        val imagePath: String = character!!.thumbnail.getUrl()
        Picasso.get().load(imagePath).into(image)

        title.text = character!!.name
    }

    private fun setupDescriptionViews() {
        if (character!!.description.isEmpty()) {
            descriptionLayout.visibility = View.GONE
        } else {
            descriptionLayout.visibility = View.VISIBLE
            description.text = character!!.description
        }
    }

    private fun setupComicsViews() {
        if (character!!.comics.items!!.isEmpty()){
            comicsLayout.visibility = View.GONE
        } else {
            comicsLayout.visibility = View.VISIBLE
            comics = character!!.comics.items!!
            setupRecyclerView()
        }
    }

    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.rvDetailRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ComicRecyclerAdapter(comics)
    }

    private fun setupMissingDataViews() {
        if (character!!.description.isNotEmpty() && character!!.comics.items!!.isNotEmpty()){
            separator.visibility = View.VISIBLE
        } else {
            separator.visibility = View.GONE
        }

        if (character!!.description.isEmpty() && character!!.comics.items!!.isEmpty()){
            noInformation.visibility = View.VISIBLE
        } else {
            noInformation.visibility = View.GONE
        }
    }

    private fun initViews() {
        image = findViewById(R.id.ivDetailImage)
        title = findViewById(R.id.tvDetailTitle)
        descriptionLayout = findViewById(R.id.rlDetailDescriptionLayout)
        description = findViewById(R.id.tvDetailDescription)
        comicsLayout = findViewById(R.id.rlDetailComicsLayout)
        separator = findViewById(R.id.vDetailSeparator)
        noInformation = findViewById(R.id.tvDetailNoInformation)

    }
}
