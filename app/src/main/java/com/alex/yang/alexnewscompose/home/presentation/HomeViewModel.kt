package com.alex.yang.alexnewscompose.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.alex.yang.alexnewscompose.home.domain.usecase.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase,
) : ViewModel() {

    val news = newsUseCase.getNews(
        sources = listOf(
            "bbc-news",
            "abc-news",
            "al-jazeera-english"
        )
    ).cachedIn(viewModelScope)
}