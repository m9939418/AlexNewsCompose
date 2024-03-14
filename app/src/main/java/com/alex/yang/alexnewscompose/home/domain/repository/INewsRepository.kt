package com.alex.yang.alexnewscompose.home.domain.repository

import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.domain.model.Article
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
interface INewsRepository {

    fun getNews(sources:List<String>):Flow<PagingData<Article>>
}