package com.masudin.mvpthemoviedb.main

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masudin.mvpthemoviedb.R
import com.masudin.mvpthemoviedb.model.Movie
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MainAdapter(private val results: List<Movie>, private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(results[position],listener)
    }
}

//class movieUi : AnkoComponent<ViewGroup> {
//    override fun createView(ui: AnkoContext<ViewGroup>): View {
//        return with(ui) {
//            linearLayout {
//                lparams(width = matchParent, height = wrapContent)
//                padding = dip(5)
//                orientation = LinearLayout.VERTICAL
//
//                imageView{
//                    id = R.id.movie_Poster
//                }.lparams{
//                    height = dip(250)
//                    width = wrapContent
//                }
//                textView{
//                    id = R.id.movie_Tittle
//                    textSize = 16f
//                }.lparams{
//                    margin = dip(20)
//                }
//
//            }
//        }
//    }
//}


class MovieHolder(view: View) : RecyclerView.ViewHolder(view) {

    val urlPoster: String = "http://image.tmdb.org/t/p/w780"
    val apiKey : String = "90b54a38972894350ba0831c5b17aad0"
    val baseUrl : String = "https://api.themoviedb.org/3/movie/popular?api_key="

    private val moviePoster : ImageView = view.findViewById(R.id.movie_Poster)
    private val movieTittle : TextView = view.findViewById(R.id.tvTittle)

    fun bind(movie: Movie, listener: (Movie) -> Unit) {
        Picasso.get().load(urlPoster + movie.poster).into(moviePoster)
        Log.d("Gambar","url = "+urlPoster+movie.poster)
        Log.d("title","url = "+urlPoster+movie.title)
        movieTittle.text = movie.title
        moviePoster.onClick {
            listener(movie)
        }
    }
}