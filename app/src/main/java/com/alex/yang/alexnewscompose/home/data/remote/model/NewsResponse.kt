package com.alex.yang.alexnewscompose.home.data.remote.model

import com.alex.yang.alexnewscompose.home.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)