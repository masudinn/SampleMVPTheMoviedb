package com.masudin.mvpthemoviedb.network

object TmdbApi {

    var BASEURL = "https://api.themoviedb.org/3/movie/popular?api_key="
    val APIKEY = "90b54a38972894350ba0831c5b17aad0"

    fun getMovie() : String{
        return BASEURL + APIKEY
    }
}