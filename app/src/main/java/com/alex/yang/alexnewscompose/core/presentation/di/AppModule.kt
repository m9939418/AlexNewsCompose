package com.alex.yang.alexnewscompose.core.presentation.di

import android.app.Application
import com.alex.yang.alexnewscompose.core.data.repository.LocalUserMangerImpl
import com.alex.yang.alexnewscompose.core.domain.repository.LocalUserManger
import com.alex.yang.alexnewscompose.main.domain.usecase.AppEntryUseCase
import com.alex.yang.alexnewscompose.main.domain.usecase.ReadAppEntry
import com.alex.yang.alexnewscompose.main.domain.usecase.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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