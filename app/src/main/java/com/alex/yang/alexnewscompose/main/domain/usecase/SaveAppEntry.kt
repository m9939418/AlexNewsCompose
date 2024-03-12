package com.alex.yang.alexnewscompose.main.domain.usecase

import com.alex.yang.alexnewscompose.core.domain.repository.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}