package com.example.domain.use_cases

import com.example.domain.Resource
import com.example.domain.model.ArticleItemModel
import kotlinx.coroutines.flow.Flow

interface ArticlesUseCase {

    operator fun invoke(): Flow<Resource<List<ArticleItemModel>>>
}