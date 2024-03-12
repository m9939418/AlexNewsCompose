package com.alex.yang.alexnewscompose.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}