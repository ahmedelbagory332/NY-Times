package com.example.data.remote

import com.example.data.Constant
import com.example.data.remote.responses.ArticlesJson
import retrofit2.http.GET

interface NewsApi {

    @GET("viewed/30.json?api-key=${Constant.ApiKey}")
    suspend fun getArticles(): ArticlesJson
}