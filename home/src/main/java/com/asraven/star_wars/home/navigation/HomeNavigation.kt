package com.asraven.star_wars.home.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.asraven.star_wars.home.HomeRoute
import androidx.navigation.navigation


import androidx.navigation.compose.composable

const val homeNavigationPattern = "homeNavigation_pattern"
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
        composable(route = homeNavigationRoute,){
            HomeRoute()
        }



    }
}





@Composable
fun Test(){
    Text("tesx")
}