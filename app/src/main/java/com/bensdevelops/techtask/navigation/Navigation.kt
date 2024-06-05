package com.bensdevelops.techtask.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bensdevelops.techtask.core.base.ui.ErrorScreen
import com.bensdevelops.techtask.ui.screens.dummy.DummyScreen
import com.bensdevelops.techtask.ui.screens.dummy.DummyScreenViewModel
import com.bensdevelops.techtask.ui.screens.home.HomeScreen
import com.bensdevelops.techtask.ui.screens.home.HomeScreenViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            val viewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(
                navController = navController,
            )
        }
        composable(
            route = Screen.DummyScreen.route
        ) {
            val viewModel = hiltViewModel<DummyScreenViewModel>()
            DummyScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.ErrorScreen.route) {
            ErrorScreen(navController = navController)
        }
    }
}