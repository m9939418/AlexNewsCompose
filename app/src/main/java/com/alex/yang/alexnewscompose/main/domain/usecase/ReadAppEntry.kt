package com.alex.yang.alexnewscompose.main.domain.usecase

import com.alex.yang.alexnewscompose.core.domain.repository.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }
}