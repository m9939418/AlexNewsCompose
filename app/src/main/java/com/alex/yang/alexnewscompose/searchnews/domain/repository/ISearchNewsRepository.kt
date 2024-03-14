package com.alex.yang.alexnewscompose.searchnews.domain.repository

import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
interface ISearchNewsRepository {
    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>
}