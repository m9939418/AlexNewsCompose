package com.alex.yang.alexnewscompose.searchnews.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alex.yang.alexnewscompose.core.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.home.domain.model.Article

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
class SearchNewsPagingSource(
    private val newsApi: NewsApi,
    private val searchQuery: String,
    private val sources: String,
) : PagingSource<Int, Article>() {
    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPage ->
            val page = state.closestPageToPosition(anchorPage)
            page?.nextKey?.minus(1) ?: page?.prevKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val response = newsApi.searchNews(
                searchQuery = searchQuery,
                sources = sources,
                page = page
            )
            totalNewsCount += response.articles.size
            val articles = response.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == response.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }
}