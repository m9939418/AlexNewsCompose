package com.alex.yang.alexnewscompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.alex.yang.alexnewscompose.domain.usecase.AppEntryUseCase
import com.alex.yang.alexnewscompose.presentation.onboading.OnBoardingScreen
import com.alex.yang.alexnewscompose.ui.theme.AlexNewsComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appEntryUseCase: AppEntryUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        lifecycleScope.launch {
            appEntryUseCase.readAppEntry().collect {
                Log.d("alexyang", it.toString())
            }
        }
        setContent {
            AlexNewsComposeTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen()
                }
            }
        }
    }
}