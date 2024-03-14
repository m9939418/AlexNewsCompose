package com.alex.yang.alexnewscompose.home.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.data.remote.NewsPagingSource
import com.alex.yang.alexnewscompose.home.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.home.domain.model.Article
import com.alex.yang.alexnewscompose.home.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
class NewsRepositoryImpl(
    private val newsApi: NewsApi,
) : INewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}