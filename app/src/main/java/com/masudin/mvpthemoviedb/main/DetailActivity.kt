package com.masudin.mvpthemoviedb.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.masudin.mvpthemoviedb.BuildConfig.URLPOSTER
import com.masudin.mvpthemoviedb.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

class DetailActivity : AppCompatActivity() {

    private var title : String? = ""
    private var poster : String? = ""
    private var overview : String? = ""

    private lateinit var posterMovie : ImageView
    private lateinit var titleMovie : TextView
    private lateinit var overviewMovie : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        posterMovie = findViewById(R.id.imagedetail)
        titleMovie = findViewById(R.id.titledetail)
        overviewMovie = findViewById(R.id.desdetail)


        val i = intent
        title = i.getStringExtra("Title")
        overview = i.getStringExtra("Overview")
        poster = i.getStringExtra("Poster")

        titleMovie.text = title
        overviewMovie.text = overview
        Picasso.get().load(URLPOSTER+poster).into(posterMovie)
    }
}