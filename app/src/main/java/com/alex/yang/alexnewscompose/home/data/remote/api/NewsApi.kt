package com.alex.yang.alexnewscompose.home.data.remote.api

import com.alex.yang.alexnewscompose.home.data.remote.model.NewsResponse
import com.alex.yang.alexnewscompose.utils.Constants
import com.alex.yang.alexnewscompose.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by AlexYang on 2024/3/12.
 *
 *
 */
interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}