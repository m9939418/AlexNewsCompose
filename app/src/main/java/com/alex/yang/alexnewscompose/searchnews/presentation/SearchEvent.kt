package com.alex.yang.alexnewscompose.searchnews.presentation

/**
 * Created by AlexYang on 2024/3/14.
 *
 *
 */
sealed class SearchEvent {
    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()
    object SearchNews : SearchEvent()
}