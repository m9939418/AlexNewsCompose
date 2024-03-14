package com.alex.yang.alexnewscompose.home.domain.usecase

import androidx.paging.PagingData
import com.alex.yang.alexnewscompose.home.domain.model.Article
import com.alex.yang.alexnewscompose.home.domain.repository.INewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
class GetNew(
    private val newsRepository: INewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}