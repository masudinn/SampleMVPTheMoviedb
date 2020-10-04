package com.masudin.mvpthemoviedb.main

import com.masudin.mvpthemoviedb.model.Movie

interface MainView{
    fun showMovieList(data : List<Movie>)
}