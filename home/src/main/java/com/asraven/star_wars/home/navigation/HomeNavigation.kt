package com.asraven.star_wars.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.asraven.star_wars.home.views.HomeRoute


private const val homeNavigationPattern = "homeNavigation_pattern"
const val homeNavigationRoute = "homeNavigation_route"


fun NavController.homeNavigation(
    navOptions: NavOptions? = null
) {
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeGenerationGraph() {
    navigation(
        route = homeNavigationPattern,
        startDestination = homeNavigationRoute
    ) {
        composable(
            route = homeNavigationRoute,
        ){
            HomeRoute()
        }

    }
}
