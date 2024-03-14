package com.alex.yang.alexnewscompose.searchnews.presentation.di

import com.alex.yang.alexnewscompose.core.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.searchnews.data.repostiory.SearchNewsRepositoryImpl
import com.alex.yang.alexnewscompose.searchnews.domain.repository.ISearchNewsRepository
import com.alex.yang.alexnewscompose.searchnews.domain.usecase.SearchNews
import com.alex.yang.alexnewscompose.searchnews.domain.usecase.SearchNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Provides
    @Singleton
    fun provideSearchNewsRepository(
        newsApi: NewsApi
    ): ISearchNewsRepository = SearchNewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideSearchNewsUseCase(
        searchNewsRepository: ISearchNewsRepository
    ): SearchNewsUseCase {
        return SearchNewsUseCase(
            searchNews = SearchNews(searchNewsRepository)
        )
    }
}