package com.example.newsapp.di

import com.example.data.remote.NewsApi
import com.example.data.repositories_impl.ArticlesRepositoryImpl
import com.example.domain.repositories.ArticlesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {


    @Provides
    @Singleton
    fun getHeadLinesRepository(api: NewsApi): ArticlesRepository =
        ArticlesRepositoryImpl(api)


}