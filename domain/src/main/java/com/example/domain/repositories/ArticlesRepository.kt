package com.example.domain.repositories

import com.example.domain.model.ArticlesModel


interface ArticlesRepository {

    suspend fun getArticles(): ArticlesModel


}