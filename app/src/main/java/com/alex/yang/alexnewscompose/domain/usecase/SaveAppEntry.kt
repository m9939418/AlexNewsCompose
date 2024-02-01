package com.alex.yang.alexnewscompose.domain.usecase

import com.alex.yang.alexnewscompose.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke() {
        localUserManger.saveAppEntry()
    }
}