package com.alex.yang.alexnewscompose.di

import android.app.Application
import com.alex.yang.alexnewscompose.data.repository.LocalUserMangerImpl
import com.alex.yang.alexnewscompose.domain.manager.LocalUserManger
import com.alex.yang.alexnewscompose.domain.usecase.AppEntryUseCase
import com.alex.yang.alexnewscompose.domain.usecase.ReadAppEntry
import com.alex.yang.alexnewscompose.domain.usecase.SaveAppEntry
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