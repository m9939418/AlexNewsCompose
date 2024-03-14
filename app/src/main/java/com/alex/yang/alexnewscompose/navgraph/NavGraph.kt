package com.alex.yang.alexnewscompose.navgraph

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alex.yang.alexnewscompose.home.presentation.HomeScreen
import com.alex.yang.alexnewscompose.home.presentation.HomeViewModel
import com.alex.yang.alexnewscompose.onboading.presentation.OnBoardingScreen
import com.alex.yang.alexnewscompose.onboading.presentation.OnBoardingViewModel
import com.alex.yang.alexnewscompose.searchnews.presentation.SearchNewsScreen
import com.alex.yang.alexnewscompose.searchnews.presentation.SearchNewsViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(
                route = Route.OnBoardingScreen.route
            ) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigationScreen.route
        ) {
            composable(
                route = Route.NewsNavigationScreen.route
            ) {
//                val viewModel: HomeViewModel = hiltViewModel()
//                val articles = viewModel.news.collectAsLazyPagingItems()
//                HomeScreen(
//                    articles = articles,
//                    navigate = {}
//                )
                val viewModel: SearchNewsViewModel = hiltViewModel()
                SearchNewsScreen(
                    state = viewModel.state.value,
                    event = viewModel::onEvent,
                    navigate = { }
                )
            }
        }
    }
}