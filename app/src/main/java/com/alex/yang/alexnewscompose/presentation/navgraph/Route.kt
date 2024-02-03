package com.alex.yang.alexnewscompose.presentation.navgraph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen : Route("OnBoardingScreen")
    object HomeScreen : Route("HomeScreen")
    object SearchScreen : Route("SearchScreen")
    object BookmarkScreen : Route("BookmarkScreen")
    object DetailScreen : Route("DetailScreen")
    object AppStartNavigation : Route("AppStartNavigation")
    object NewsNavigation : Route("NewsNavigation")
    object NewsNavigationScreen : Route(route = "NewsNavigationScreen")
}
