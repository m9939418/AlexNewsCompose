package com.alex.yang.alexnewscompose.searchnews.presentation

import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)
