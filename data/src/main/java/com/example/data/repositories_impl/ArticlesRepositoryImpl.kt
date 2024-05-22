package com.example.data.repositories_impl

import com.example.data.mapper.toDomain
import com.example.data.remote.NewsApi
import com.example.domain.model.ArticlesModel
import com.example.domain.repositories.ArticlesRepository
import javax.inject.Inject


class ArticlesRepositoryImpl @Inject constructor(private val api: NewsApi) :
    ArticlesRepository {


    override suspend fun getArticles(): ArticlesModel {
        return api.getArticles().toDomain()
    }
}