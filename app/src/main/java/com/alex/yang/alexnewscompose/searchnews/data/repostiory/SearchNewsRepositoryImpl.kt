package com.alex.yang.alexnewscompose.searchnews.data.repostiory

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.core.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.home.domain.model.Article
import com.alex.yang.alexnewscompose.searchnews.data.remote.SearchNewsPagingSource
import com.alex.yang.alexnewscompose.searchnews.domain.repository.ISearchNewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
class SearchNewsRepositoryImpl(
    private val newsApi: NewsApi,
) : ISearchNewsRepository {

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}