package com.alex.yang.alexnewscompose.core.presentation.di

import android.app.Application
import com.alex.yang.alexnewscompose.core.data.repository.LocalUserMangerImpl
import com.alex.yang.alexnewscompose.core.domain.repository.LocalUserManger
import com.alex.yang.alexnewscompose.core.data.remote.api.NewsApi
import com.alex.yang.alexnewscompose.main.domain.usecase.AppEntryUseCase
import com.alex.yang.alexnewscompose.main.domain.usecase.ReadAppEntry
import com.alex.yang.alexnewscompose.main.domain.usecase.SaveAppEntry
import com.alex.yang.alexnewscompose.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalUserMangerImpl(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManger: LocalUserManger
    ) = AppEntryUseCase(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}