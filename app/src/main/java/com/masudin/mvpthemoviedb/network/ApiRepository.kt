package com.masudin.mvpthemoviedb.network

import java.net.URL

class ApiRepository {
    fun doRequst(url : String) : String{
        return URL(url).readText()
    }
}