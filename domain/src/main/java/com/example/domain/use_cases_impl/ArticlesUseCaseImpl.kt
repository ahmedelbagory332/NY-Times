package com.example.domain.use_cases_impl

import com.example.domain.Resource
import com.example.domain.model.ArticleItemModel
import com.example.domain.repositories.ArticlesRepository
import com.example.domain.use_cases.ArticlesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticlesUseCaseImpl @Inject constructor(
    private val articlesRepository: ArticlesRepository,
) : ArticlesUseCase {


    override fun invoke(): Flow<Resource<List<ArticleItemModel>>> = flow {
        try {
            emit(Resource.Loading<List<ArticleItemModel>>())
            val articles = articlesRepository.getArticles()
            emit(Resource.Success<List<ArticleItemModel>>(articles.results))
        } catch(e: Exception) {
            emit(Resource.Error<List<ArticleItemModel>>("${e.localizedMessage} : An unexpected error happened"))

        }
    }

}