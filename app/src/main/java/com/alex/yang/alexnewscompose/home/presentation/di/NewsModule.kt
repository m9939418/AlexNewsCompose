package com.alex.yang.alexnewscompose.home.presentation.di

import com.alex.yang.alexnewscompose.home.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.home.data.repository.NewsRepositoryImpl
import com.alex.yang.alexnewscompose.home.domain.repository.INewsRepository
import com.alex.yang.alexnewscompose.home.domain.usecase.GetNew
import com.alex.yang.alexnewscompose.home.domain.usecase.NewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): INewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCase(
        newsRepository: INewsRepository
    ): NewsUseCase {
        return NewsUseCase(
            getNews = GetNew(newsRepository)
        )
    }
}