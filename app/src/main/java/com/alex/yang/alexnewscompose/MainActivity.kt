package com.alex.yang.alexnewscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.alex.yang.alexnewscompose.presentation.onboading.OnBoardingScreen
import com.alex.yang.alexnewscompose.presentation.onboading.OnBoardingViewModel
import com.alex.yang.alexnewscompose.ui.theme.AlexNewsComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        setContent {
            AlexNewsComposeTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                    OnBoardingScreen(
                        event = viewModel::onEvent
//                        event = {
//                            viewModel.onEvent(it)
//                        }
                    )
                }
            }
        }
    }
}