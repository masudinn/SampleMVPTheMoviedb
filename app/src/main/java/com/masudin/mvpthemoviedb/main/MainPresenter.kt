package com.masudin.mvpthemoviedb.main

import com.google.gson.Gson
import com.masudin.mvpthemoviedb.model.MovieResponse
import com.masudin.mvpthemoviedb.network.ApiRepository
import com.masudin.mvpthemoviedb.network.TmdbApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view : MainView,private val apiRepository: ApiRepository,private val gson: Gson){
    fun getMovieList(){
        doAsync {
            val data = gson.fromJson(apiRepository.doRequst(TmdbApi.getMovie()),
            MovieResponse::class.java)
            uiThread {
                view.showMovieList(data.results)
            }
        }
    }
}
