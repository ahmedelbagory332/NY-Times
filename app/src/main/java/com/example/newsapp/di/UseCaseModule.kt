package com.example.newsapp.di

import com.example.domain.repositories.ArticlesRepository
import com.example.domain.use_cases.ArticlesUseCase
import com.example.domain.use_cases_impl.ArticlesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {


    @Provides
    @Singleton
    fun getHeadLinesUseCase(articlesRepository: ArticlesRepository): ArticlesUseCase =
        ArticlesUseCaseImpl(articlesRepository)

}