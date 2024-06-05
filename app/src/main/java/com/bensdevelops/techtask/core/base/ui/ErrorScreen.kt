package com.bensdevelops.techtask.core.base.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bensdevelops.techtask.navigation.Screen

/*
Predominantly this screen should be called if there is an error when displaying view data or if
navigation fails.
A simple more graceful way of the app having a problem than just crashing.
 */

@Composable
fun ErrorScreen(
    navController: NavController,
) {
    Surface(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column {
            Text(text = "Please return home")
            Button(onClick = { navController.navigate(Screen.HomeScreen.route) }) {
                Text(text = "Home")
            }
        }
    }
}