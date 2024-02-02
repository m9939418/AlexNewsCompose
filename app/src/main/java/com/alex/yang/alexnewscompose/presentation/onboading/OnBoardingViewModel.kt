package com.alex.yang.alexnewscompose.presentation.onboading

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.yang.alexnewscompose.domain.usecase.AppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUseCase: AppEntryUseCase,
) : ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when (event) {
            OnBoardingEvent.SaveAppEntry -> saveAppEntry()
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCase.saveAppEntry()
        }
    }
}