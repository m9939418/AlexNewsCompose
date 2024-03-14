package com.alex.yang.alexnewscompose.searchnews.domain.usecase

import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.domain.model.Article
import com.alex.yang.alexnewscompose.searchnews.domain.repository.ISearchNewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
class SearchNews(
    private val searchNewsRepository: ISearchNewsRepository
) {

    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return searchNewsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}