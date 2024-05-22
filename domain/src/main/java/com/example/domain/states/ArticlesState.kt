package com.example.domain.states

import com.example.domain.model.ArticleItemModel


data class ArticlesState (
    val isLoading: Boolean = false,
    val listArticles : List<ArticleItemModel>  = emptyList(),
    val error: String = ""
)