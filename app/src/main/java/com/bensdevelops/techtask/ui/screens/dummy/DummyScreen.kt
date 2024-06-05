package com.bensdevelops.techtask.ui.screens.dummy

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DummyScreen(
    navController: NavController,
    viewModel: DummyScreenViewModel = hiltViewModel(),
) {
    DummyScreenContent()
}

@Composable
private fun DummyScreenContent() {

}